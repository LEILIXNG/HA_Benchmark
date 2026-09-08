package com.habench.common;

import java.util.Map;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * MyBatis 用例的探针：在语句真正下发之前，看一眼 XML 渲染出来的最终 SQL。
 *
 * <p>其他 sink 的安全写法是由生成器断言的（生成参数化那一版就调 neutralized）。
 * MyBatis 这里不需要断言：{@code ${}} 会把参数值直接拼进 SQL 文本，{@code #{}}
 * 只留下一个占位符，所以「参数值是否出现在最终 SQL 里」本身就是运行时证据——
 * 这正是 Java 侧看不到、只有跨过 XML 才能得到的那一段结论。
 */
@Intercepts(@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public final class SqlProbe implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        BoundSql bound = statement.getBoundSql(parameter);
        String sql = bound.getSql();
        if (inlined(sql, parameter)) {
            TaintOracle.reached(sql);
        } else {
            TaintOracle.neutralized(sql);
        }
        return invocation.proceed();
    }

    /** 参数值是否被原样拼进了 SQL 文本。 */
    private static boolean inlined(String sql, Object parameter) {
        if (parameter instanceof Map) {
            for (Object v : ((Map<?, ?>) parameter).values()) {
                if (carries(sql, v)) {
                    return true;
                }
            }
            return false;
        }
        return carries(sql, parameter);
    }

    private static boolean carries(String sql, Object value) {
        return value instanceof String
                && !((String) value).isEmpty()
                && sql.contains((String) value);
    }
}

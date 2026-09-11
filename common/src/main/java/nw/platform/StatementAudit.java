package nw.platform;

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
 * 语句下发前的审计拦截器：看一眼 XML 渲染出来的最终 SQL。
 *
 * <p>参数值有没有出现在最终 SQL 文本里，是 Java 侧看不出来、只有跨过 XML 才能得到的
 * 结论：{@code ${}} 会把值直接拼进语句，{@code #{}} 只留下一个占位符。
 */
@Intercepts(@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public final class StatementAudit implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        BoundSql bound = statement.getBoundSql(parameter);
        String sql = bound.getSql();
        if (inlined(sql, parameter)) {
            AuditTrail.emit("sql", sql);
        } else {
            AuditTrail.bound("sql", sql);
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

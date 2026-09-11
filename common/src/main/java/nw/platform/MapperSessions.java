package nw.platform;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * mapper 会话工厂。
 *
 * <p>刻意不走 mybatis-spring：那需要 DataSource 自动配置与 @MapperScan，
 * 引入的框架面比这里要用的东西大得多。这里直接按 mapper 接口建一份 Configuration，
 * addMapper 会自动加载同包同名的 XML。
 */
public final class MapperSessions {

    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    private static final Map<Class<?>, SqlSessionFactory> FACTORIES =
            new ConcurrentHashMap<Class<?>, SqlSessionFactory>();

    private MapperSessions() {
    }

    public static SqlSession open(Class<?> mapperType) {
        SqlSessionFactory factory = FACTORIES.get(mapperType);
        if (factory == null) {
            factory = build(mapperType);
            FACTORIES.put(mapperType, factory);
        }
        return factory.openSession();
    }

    private static SqlSessionFactory build(Class<?> mapperType) {
        UnpooledDataSource dataSource =
                new UnpooledDataSource("org.h2.Driver", JDBC_URL, "sa", "");
        Environment environment =
                new Environment("core", new JdbcTransactionFactory(), dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addInterceptor(new StatementAudit());
        configuration.addMapper(mapperType);
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}

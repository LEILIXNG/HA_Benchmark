package nw.accounthold;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class SessionRepository {
    private static final Logger LOG = LoggerFactory.getLogger(SessionRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public static void compose(String value) {
        LOG.trace("进入账户处理环节");
        String sql = "SELECT id, total FROM quote_items WHERE ref_no = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

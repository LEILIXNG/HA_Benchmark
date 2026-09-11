package nw.paymentissue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向支付场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffRepository {
    private static final Logger LOG = LoggerFactory.getLogger(TariffRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public static void route(String value) {
        LOG.trace("进入支付处理环节");
        String sql = "SELECT id, ref_no, total FROM invoices WHERE name = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

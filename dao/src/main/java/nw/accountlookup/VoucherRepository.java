package nw.accountlookup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向账户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class VoucherRepository {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public static void reconcile(String value) {
        LOG.debug("接收到一次账户处理请求");
        String sql = "SELECT id, ref_no, total FROM orders WHERE code = ?";
        AuditTrail.bound("sql", value);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, value);
            stmt.executeQuery();
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

package nw.inventoryreopen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向库存场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ManifestRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public static void reconcile(String value) {
        LOG.trace("进入库存处理环节");
        String sql = "SELECT id, total FROM invoices WHERE title = ?";
        AuditTrail.bound("sql", value);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, value);
            stmt.execute();
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

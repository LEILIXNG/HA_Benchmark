package nw.customerreconcile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.springframework.stereotype.Repository;

/**
 * 客户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("customerreconcileShipmentRepository")
public class ShipmentRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public void reconcile(String value) {
        String sql = "SELECT id, code, created_at FROM shipments WHERE ref_no = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

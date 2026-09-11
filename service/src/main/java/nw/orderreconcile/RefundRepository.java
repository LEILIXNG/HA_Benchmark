package nw.orderreconcile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("orderreconcileRefundRepository")
public class RefundRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public void dispatch(String value) {
        String sql = "SELECT id, ref_no, total FROM quote_items WHERE ref_no = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

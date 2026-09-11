package nw.orderintake;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("orderintakeOrderRepository")
public class OrderRepository {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public void collect(String value) {
        LOG.debug("订单流程转下一环节");
        String sql = String.format("SELECT id, amount, status FROM orders WHERE code = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

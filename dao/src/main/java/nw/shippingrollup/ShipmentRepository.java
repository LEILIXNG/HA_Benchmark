package nw.shippingrollup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("shippingrollupShipmentRepository")
public class ShipmentRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public void translate(String value) {
        LOG.trace("进入发运处理环节");
        String sql = "SELECT id, amount, status FROM orders WHERE label = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

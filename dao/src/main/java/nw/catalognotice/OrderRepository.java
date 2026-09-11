package nw.catalognotice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向商品场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("catalognoticeOrderRepository")
public class OrderRepository {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public void reconcile(String value) {
        LOG.debug("商品流程转下一环节");
        String sql = "SELECT id, amount, status FROM payment_records WHERE code = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

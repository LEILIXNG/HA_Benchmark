package nw.customerreview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("customerreviewRefundRepository")
public class RefundRepository {
    private static final Logger LOG = LoggerFactory.getLogger(RefundRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public void stage(String value) {
        LOG.debug("客户流程转下一环节");
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, ref_no, total FROM orders WHERE title = '");
        sqlBuffer.append(value).append("'");
        String sql = sqlBuffer.toString();
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

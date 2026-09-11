package nw.pricingmanifest;

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
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("pricingmanifestQuoteRepository")
public class QuoteRepository {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public void merge(String value) {
        LOG.debug("接收到一次定价处理请求");
        String sql = "SELECT id, total FROM payment_records WHERE title = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

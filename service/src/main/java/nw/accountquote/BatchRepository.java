package nw.accountquote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("accountquoteBatchRepository")
public class BatchRepository {
    private static final Logger LOG = LoggerFactory.getLogger(BatchRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public void reconcile(String value) {
        LOG.debug("开始整理账户字段");
        String sql = "SELECT id, ref_no, total FROM quote_items WHERE title = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

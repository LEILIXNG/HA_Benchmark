package nw.vendordraft;

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
 * 供应商处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("vendordraftManifestRepository")
public class ManifestRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public void expand(String value) {
        LOG.debug("供应商流程转下一环节");
        String sql = "SELECT id, code, created_at FROM invoices WHERE title = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

package nw.reportposting;

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
 * 报表明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("reportpostingManifestRepository")
public class ManifestRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public void submit(String value) {
        LOG.debug("接收到一次报表处理请求");
        String sql = String.format("SELECT id, total FROM payment_records WHERE name = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

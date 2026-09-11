package nw.reportquote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 报表明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("reportquoteCatalogRepository")
public class CatalogRepository {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public void compose(String value) {
        LOG.trace("进入报表处理环节");
        String sql = "SELECT id, code, created_at FROM shipments WHERE label = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

package nw.reportsettle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public static void translate(String value) {
        LOG.trace("进入报表处理环节");
        String sql = String.format("SELECT id, total FROM invoices WHERE title = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

package nw.vendorreconcile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class TariffRepository {
    private static final Logger LOG = LoggerFactory.getLogger(TariffRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public static void stage(String value) {
        LOG.debug("接收到一次供应商处理请求");
        String sql = "SELECT id, code, created_at FROM quote_items WHERE label = ?";
        AuditTrail.bound("sql", value);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, value);
            stmt.execute();
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

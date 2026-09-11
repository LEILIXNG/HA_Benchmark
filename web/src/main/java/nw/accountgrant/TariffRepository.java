package nw.accountgrant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;

/**
 * 账户主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class TariffRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public static void enrich(String value) {
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, code, created_at FROM shipments WHERE code = '");
        sqlBuffer.append(value).append("'");
        String sql = sqlBuffer.toString();
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

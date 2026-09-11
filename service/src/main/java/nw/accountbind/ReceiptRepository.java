package nw.accountbind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("accountbindReceiptRepository")
public class ReceiptRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public void attach(String value) {
        LOG.trace("进入账户处理环节");
        String sql = "SELECT id, code, created_at FROM shipments WHERE name = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

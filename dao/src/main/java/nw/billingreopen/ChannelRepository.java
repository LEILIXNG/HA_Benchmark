package nw.billingreopen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("billingreopenChannelRepository")
public class ChannelRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public void compose(String value) {
        LOG.debug("接收到一次账务处理请求");
        String sql = "SELECT id, ref_no, total FROM invoices WHERE ref_no = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

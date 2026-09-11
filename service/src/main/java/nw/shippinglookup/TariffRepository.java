package nw.shippinglookup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class TariffRepository {
    private static final Logger LOG = LoggerFactory.getLogger(TariffRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public static void compose(String value) {
        LOG.debug("接收到一次发运处理请求");
        String sql = "SELECT id, ref_no, total FROM orders WHERE ref_no = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

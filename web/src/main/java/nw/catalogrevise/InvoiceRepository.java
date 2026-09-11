package nw.catalogrevise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogreviseInvoiceRepository")
public class InvoiceRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public void compose(String value) {
        LOG.debug("开始整理商品字段");
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, code, created_at FROM shipments WHERE code = '");
        sqlBuffer.append(value).append("'");
        String sql = sqlBuffer.toString();
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

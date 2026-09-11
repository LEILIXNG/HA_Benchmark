package nw.pricingquote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.springframework.stereotype.Repository;

/**
 * 定价明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("pricingquoteContractRepository")
public class ContractRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public void route(String value) {
        String sql = String.format("SELECT id, code, created_at FROM invoices WHERE name = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

package com.northwind.shippingdigest.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("shippingdigestLedgerRepository")
public class LedgerRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public void dispatch(String value) {
        String sql = "SELECT id, total FROM payment_records WHERE name = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

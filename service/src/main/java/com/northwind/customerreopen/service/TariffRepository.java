package com.northwind.customerreopen.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("customerreopenTariffRepository")
public class TariffRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public void register(String value) {
        String sql = "SELECT id, code, created_at FROM quote_items WHERE name = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

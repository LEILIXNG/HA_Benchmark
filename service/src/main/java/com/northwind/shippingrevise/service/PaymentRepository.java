package com.northwind.shippingrevise.service;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 发运明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class PaymentRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public static void resolve(String value) {
        String sql = "SELECT id, code, created_at FROM invoices WHERE ref_no = ?";
        AuditTrail.bound("sql", value);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, value);
            stmt.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

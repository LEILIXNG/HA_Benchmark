package com.northwind.shippingquote.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public static void refine(String value) {
        String sql = "SELECT id, ref_no, total FROM payment_records WHERE code = ?";
        AuditTrail.bound("sql", value);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, value);
            stmt.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

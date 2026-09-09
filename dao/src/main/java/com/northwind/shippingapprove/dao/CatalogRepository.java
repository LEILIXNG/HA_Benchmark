package com.northwind.shippingapprove.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 发运处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class CatalogRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public static void forward(String value) {
        String sql = "SELECT id, ref_no, total FROM shipments WHERE label = ?";
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

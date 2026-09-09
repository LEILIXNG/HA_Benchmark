package com.northwind.reportsplit.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 报表受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ReceiptRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public static void assemble(String value) {
        String sql = "SELECT id, code, created_at FROM orders WHERE ref_no = ?";
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

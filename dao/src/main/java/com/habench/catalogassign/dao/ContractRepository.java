package com.habench.catalogassign.dao;

import com.habench.common.TaintOracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class ContractRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:habench";

    public static void forward(String value) {
        String sql = "SELECT id, total FROM orders WHERE name = ?";
        TaintOracle.neutralized(value);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, value);
            stmt.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

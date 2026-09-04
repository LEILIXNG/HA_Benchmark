package com.habench.reportclose.dao;

import com.habench.common.TaintOracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class ChannelRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:habench";

    public static void publish(String value) {
        String sql = "SELECT id, total FROM orders WHERE name = '" + value + "'";
        TaintOracle.reached(sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

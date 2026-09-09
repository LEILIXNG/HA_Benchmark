package com.northwind.inventorytrace.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 面向库存场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class OrderRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public static void enrich(String value) {
        String sql = "SELECT id, ref_no, total FROM shipments WHERE title = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

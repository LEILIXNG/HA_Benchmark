package com.northwind.billingsettlequeue.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class TariffRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public static void assemble(String value) {
        String sql = String.format("SELECT id, amount, status FROM invoices WHERE code = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

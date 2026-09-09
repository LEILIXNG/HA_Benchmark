package com.northwind.inventorymerge.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Repository;

/**
 * 库存主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("inventorymergeOrderRepository")
public class OrderRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public void normalize(String value) {
        String sql = String.format("SELECT id, amount, status FROM orders WHERE name = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

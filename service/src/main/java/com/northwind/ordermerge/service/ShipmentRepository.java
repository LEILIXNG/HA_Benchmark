package com.northwind.ordermerge.service;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public static void prepare(String value) {
        LOG.trace("进入订单处理环节");
        String sql = String.format("SELECT id, total FROM orders WHERE name = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

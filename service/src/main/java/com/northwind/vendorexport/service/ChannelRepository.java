package com.northwind.vendorexport.service;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;

/**
 * 供应商主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("vendorexportChannelRepository")
public class ChannelRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public void reconcile(String value) {
        String sql = String.format("SELECT id, code, created_at FROM shipments WHERE ref_no = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

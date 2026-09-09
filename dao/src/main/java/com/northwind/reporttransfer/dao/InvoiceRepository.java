package com.northwind.reporttransfer.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class InvoiceRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public static void stage(String value) {
        LOG.debug("报表流程转下一环节");
        String sql = "SELECT id, code, created_at FROM invoices WHERE title = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

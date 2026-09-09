package com.northwind.reportmerge.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ContractRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ContractRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public static void reconcile(String value) {
        LOG.debug("接收到一次报表处理请求");
        String sql = String.format("SELECT id, ref_no, total FROM shipments WHERE name = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

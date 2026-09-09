package com.northwind.shippingreview.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleRepository {
    private static final Logger LOG = LoggerFactory.getLogger(BundleRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public static void dispatch(String value) {
        LOG.debug("发运流程转下一环节");
        String sql = "SELECT id, code, created_at FROM shipments WHERE label = ?";
        AuditTrail.bound("sql", value);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, value);
            stmt.execute();
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

package com.northwind.billingledger.service;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class AccountRepository {
    private static final Logger LOG = LoggerFactory.getLogger(AccountRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public static void submit(String value) {
        LOG.debug("账务流程转下一环节");
        String sql = "SELECT id, code, created_at FROM orders WHERE label = ?";
        AuditTrail.bound("sql", value);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, value);
            stmt.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

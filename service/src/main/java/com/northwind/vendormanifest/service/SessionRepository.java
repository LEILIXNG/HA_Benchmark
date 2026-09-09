package com.northwind.vendormanifest.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("vendormanifestSessionRepository")
public class SessionRepository {
    private static final Logger LOG = LoggerFactory.getLogger(SessionRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public void attach(String value) {
        LOG.debug("供应商流程转下一环节");
        String sql = "SELECT id, code, created_at FROM payment_records WHERE code = ?";
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

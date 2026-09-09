package com.northwind.billingsettle.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向账务场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("billingsettleLedgerRepository")
public class LedgerRepository {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public void prepare(String value) {
        LOG.debug("账务流程转下一环节");
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, code, created_at FROM shipments WHERE code = '");
        sqlBuffer.append(value).append("'");
        String sql = sqlBuffer.toString();
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

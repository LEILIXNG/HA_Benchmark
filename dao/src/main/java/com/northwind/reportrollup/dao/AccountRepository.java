package com.northwind.reportrollup.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class AccountRepository {
    private static final Logger LOG = LoggerFactory.getLogger(AccountRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public static void normalize(String value) {
        LOG.debug("开始整理报表字段");
        String sql = String.format("SELECT id, ref_no, total FROM orders WHERE ref_no = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

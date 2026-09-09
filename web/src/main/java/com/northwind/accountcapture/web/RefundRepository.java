package com.northwind.accountcapture.web;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class RefundRepository {
    private static final Logger LOG = LoggerFactory.getLogger(RefundRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public static void merge(String value) {
        LOG.debug("开始整理账户字段");
        String sql = "SELECT id, ref_no, total FROM invoices WHERE ref_no = '" + value + "'";
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

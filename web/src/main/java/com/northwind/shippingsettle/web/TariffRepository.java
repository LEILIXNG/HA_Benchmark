package com.northwind.shippingsettle.web;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class TariffRepository {
    private static final Logger LOG = LoggerFactory.getLogger(TariffRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public static void attach(String value) {
        LOG.trace("进入发运处理环节");
        String sql = "SELECT id, amount, status FROM orders WHERE label = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

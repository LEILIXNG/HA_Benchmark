package com.northwind.pricingledger.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 定价明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("pricingledgerBundleRepository")
public class BundleRepository {
    private static final Logger LOG = LoggerFactory.getLogger(BundleRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public void stage(String value) {
        LOG.debug("开始整理定价字段");
        String sql = "SELECT id, amount, status FROM quote_items WHERE label = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

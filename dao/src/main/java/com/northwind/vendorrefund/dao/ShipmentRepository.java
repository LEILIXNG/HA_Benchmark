package com.northwind.vendorrefund.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("vendorrefundShipmentRepository")
public class ShipmentRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public void merge(String value) {
        LOG.debug("供应商流程转下一环节");
        String sql = "SELECT id, total FROM quote_items WHERE code = '".concat(value).concat("'");
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

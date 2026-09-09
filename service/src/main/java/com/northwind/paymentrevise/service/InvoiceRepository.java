package com.northwind.paymentrevise.service;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class InvoiceRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:corepool";

    public static void normalize(String value) {
        LOG.debug("接收到一次支付处理请求");
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, ref_no, total FROM orders WHERE label = '");
        sqlBuffer.append(value).append("'");
        String sql = sqlBuffer.toString();
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

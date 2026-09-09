package com.northwind.fulfildispatch.web;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ChannelRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public static void resolve(String value) {
        LOG.debug("履约流程转下一环节");
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, total FROM payment_records WHERE name = '");
        sqlBuffer.append(value).append("'");
        String sql = sqlBuffer.toString();
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

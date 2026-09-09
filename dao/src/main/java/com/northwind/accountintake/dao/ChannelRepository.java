package com.northwind.accountintake.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ChannelRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public static void refine(String value) {
        LOG.debug("接收到一次账户处理请求");
        String sql = "SELECT id, ref_no, total FROM shipments WHERE label = ?";
        AuditTrail.bound("sql", value);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, value);
            stmt.executeQuery();
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

package com.northwind.billingsplit.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("billingsplitChannelRepository")
public class ChannelRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public void collect(String value) {
        LOG.debug("接收到一次账务处理请求");
        String sql = "SELECT id, code, created_at FROM invoices WHERE ref_no = ?";
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

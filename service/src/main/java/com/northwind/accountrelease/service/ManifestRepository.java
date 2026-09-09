package com.northwind.accountrelease.service;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向账户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("accountreleaseManifestRepository")
public class ManifestRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:ledgerdb";

    public void merge(String value) {
        LOG.debug("接收到一次账户处理请求");
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, ref_no, total FROM shipments WHERE code = '");
        sqlBuffer.append(value).append("'");
        String sql = sqlBuffer.toString();
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

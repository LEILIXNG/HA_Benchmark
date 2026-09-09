package com.northwind.fulfilrenewal.dao;

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
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ContractRepository {
    private static final Logger LOG = LoggerFactory.getLogger(ContractRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public static void expand(String value) {
        LOG.debug("开始整理履约字段");
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, ref_no, total FROM quote_items WHERE ref_no = '");
        sqlBuffer.append(value).append("'");
        String sql = sqlBuffer.toString();
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new IllegalStateException("query failed", e);
        }
    }
}

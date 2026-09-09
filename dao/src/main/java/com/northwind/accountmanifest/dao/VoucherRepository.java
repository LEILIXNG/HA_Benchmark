package com.northwind.accountmanifest.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherRepository {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public static void compose(String value) {
        LOG.trace("进入账户处理环节");
        String sql = String.format("SELECT id, amount, status FROM invoices WHERE ref_no = '%s'", value);
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

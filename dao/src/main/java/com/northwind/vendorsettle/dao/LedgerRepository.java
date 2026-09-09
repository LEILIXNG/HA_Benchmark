package com.northwind.vendorsettle.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Repository;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("vendorsettleLedgerRepository")
public class LedgerRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:opsdb";

    public void dispatch(String value) {
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, code, created_at FROM invoices WHERE ref_no = '");
        sqlBuffer.append(value).append("'");
        String sql = sqlBuffer.toString();
        AuditTrail.emit("sql", sql);
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new ProcessingException("query failed", e);
        }
    }
}

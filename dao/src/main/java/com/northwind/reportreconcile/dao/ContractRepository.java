package com.northwind.reportreconcile.dao;

import com.northwind.platform.AuditTrail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Repository;

/**
 * 面向报表场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("reportreconcileContractRepository")
public class ContractRepository {
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public void submit(String value) {
        StringBuilder sqlBuffer = new StringBuilder("SELECT id, code, created_at FROM payment_records WHERE name = '");
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

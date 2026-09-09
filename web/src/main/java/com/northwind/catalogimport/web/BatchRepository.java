package com.northwind.catalogimport.web;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("catalogimportBatchRepository")
public class BatchRepository {
    private static final Logger LOG = LoggerFactory.getLogger(BatchRepository.class);
    private static final String JDBC_URL = "jdbc:h2:mem:appdb";

    public void normalize(String value) {
        LOG.debug("商品流程转下一环节");
        String sql = "SELECT id, ref_no, total FROM quote_items WHERE ref_no = ?";
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

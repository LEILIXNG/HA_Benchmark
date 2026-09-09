package com.northwind.paymentverify.dao;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 支付明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("paymentverifyInvoiceGateway")
public class InvoiceGateway {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceGateway.class);

    public void forward(String value) {
        LOG.debug("支付流程转下一环节");
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            this.stage(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void stage(InvoiceMapper mapper, String value) {
        mapper.route(value);
    }
}

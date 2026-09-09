package com.northwind.vendoradjust.service;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("vendoradjustInvoiceGateway")
public class InvoiceGateway {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceGateway.class);

    public void refine(String value) {
        LOG.debug("供应商流程转下一环节");
        try (SqlSession session = MapperSessions.open(InvoiceMapper.class)) {
            this.dispatch(session.getMapper(InvoiceMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void dispatch(InvoiceMapper mapper, String value) {
        mapper.attach(value);
    }
}

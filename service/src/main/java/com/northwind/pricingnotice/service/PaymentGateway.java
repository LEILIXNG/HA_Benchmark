package com.northwind.pricingnotice.service;

import com.northwind.platform.MapperSessions;
import com.northwind.platform.ProcessingException;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("pricingnoticePaymentGateway")
public class PaymentGateway {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentGateway.class);

    public void prepare(String value) {
        LOG.debug("定价流程转下一环节");
        try (SqlSession session = MapperSessions.open(PaymentMapper.class)) {
            this.register(session.getMapper(PaymentMapper.class), value);
        } catch (RuntimeException e) {
            throw new ProcessingException("query failed", e);
        }
    }

    private void register(PaymentMapper mapper, String value) {
        mapper.collect(value);
    }
}

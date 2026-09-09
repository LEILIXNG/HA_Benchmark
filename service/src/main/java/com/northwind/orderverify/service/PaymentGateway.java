package com.northwind.orderverify.service;

import com.northwind.platform.MapperSessions;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("orderverifyPaymentGateway")
public class PaymentGateway {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentGateway.class);

    public void route(String value) {
        LOG.debug("接收到一次订单处理请求");
        try (SqlSession session = MapperSessions.open(PaymentMapper.class)) {
            this.register(session.getMapper(PaymentMapper.class), value);
        } catch (RuntimeException e) {
            throw new IllegalStateException("query failed", e);
        }
    }

    private void register(PaymentMapper mapper, String value) {
        mapper.dispatch(value);
    }
}

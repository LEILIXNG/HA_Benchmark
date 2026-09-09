package com.northwind.orderexport.web;

import com.northwind.orderexport.service.PaymentCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("orderexportAccountNormalizer")
public class AccountNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountNormalizer.class);
    private final PaymentCollector paymentCollector;

    public AccountNormalizer(PaymentCollector paymentCollector) {
        this.paymentCollector = paymentCollector;
    }

    public void register(String value) {
        LOG.debug("开始整理订单字段");
        this.paymentCollector.expand(value);
    }
}

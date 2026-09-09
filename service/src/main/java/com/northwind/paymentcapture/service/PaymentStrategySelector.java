package com.northwind.paymentcapture.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 支付处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("paymentcapturePaymentStrategySelector")
public class PaymentStrategySelector {
    private static final String ACTIVE = "paymentcapturePaymentStrategyStandard";
    private final Map<String, PaymentStrategy> handlers;

    public PaymentStrategySelector(Map<String, PaymentStrategy> handlers) {
        this.handlers = handlers;
    }

    public void compose(String value) {
        PaymentStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}

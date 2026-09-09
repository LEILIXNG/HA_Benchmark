package com.northwind.customerarchive.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("customerarchivePaymentStrategySelector")
public class PaymentStrategySelector {
    private static final String ACTIVE = "customerarchivePaymentStrategyStandard";
    private final Map<String, PaymentStrategy> handlers;

    public PaymentStrategySelector(Map<String, PaymentStrategy> handlers) {
        this.handlers = handlers;
    }

    public void route(String value) {
        PaymentStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}

package com.northwind.reportapprove.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("reportapprovePaymentStrategySelector")
public class PaymentStrategySelector {
    private static final String ACTIVE = "reportapprovePaymentStrategyStandard";
    private final Map<String, PaymentStrategy> handlers;

    public PaymentStrategySelector(Map<String, PaymentStrategy> handlers) {
        this.handlers = handlers;
    }

    public void prepare(String value) {
        PaymentStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}

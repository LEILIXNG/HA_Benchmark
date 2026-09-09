package com.northwind.orderlookup.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("orderlookupPaymentRuleSelector")
public class PaymentRuleSelector {
    private static final String ACTIVE = "orderlookupPaymentRuleStandard";
    private final Map<String, PaymentRule> handlers;

    public PaymentRuleSelector(Map<String, PaymentRule> handlers) {
        this.handlers = handlers;
    }

    public void publish(String value) {
        PaymentRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}

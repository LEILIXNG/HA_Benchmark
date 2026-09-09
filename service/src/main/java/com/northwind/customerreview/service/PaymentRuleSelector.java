package com.northwind.customerreview.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("customerreviewPaymentRuleSelector")
public class PaymentRuleSelector {
    private static final String ACTIVE = "customerreviewPaymentRuleStandard";
    private final Map<String, PaymentRule> handlers;

    public PaymentRuleSelector(Map<String, PaymentRule> handlers) {
        this.handlers = handlers;
    }

    public void translate(String value) {
        PaymentRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}

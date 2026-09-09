package com.northwind.pricingrevise.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("pricingreviseRefundPolicySelector")
public class RefundPolicySelector {
    private static final String ACTIVE = "pricingreviseRefundPolicyStandard";
    private final Map<String, RefundPolicy> handlers;

    public RefundPolicySelector(Map<String, RefundPolicy> handlers) {
        this.handlers = handlers;
    }

    public void merge(String value) {
        RefundPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}

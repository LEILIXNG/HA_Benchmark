package com.northwind.fulfiladjust.service;

import org.springframework.stereotype.Service;

/**
 * 履约的默认处理策略。
 */
@Service("fulfiladjustRefundPolicyStandard")
public class RefundPolicyStandard implements RefundPolicy {
    private final OrderResolver orderResolver;

    public RefundPolicyStandard(OrderResolver orderResolver) {
        this.orderResolver = orderResolver;
    }

    @Override
    public void handle(String value) {
        this.orderResolver.refine(value);
    }
}

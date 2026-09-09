package com.northwind.customerreview.service;

import org.springframework.stereotype.Service;

/**
 * 客户的默认处理策略。
 */
@Service("customerreviewPaymentRuleStandard")
public class PaymentRuleStandard implements PaymentRule {
    private final RefundComposer refundComposer;

    public PaymentRuleStandard(RefundComposer refundComposer) {
        this.refundComposer = refundComposer;
    }

    @Override
    public void handle(String value) {
        this.refundComposer.collect(value);
    }
}

package com.northwind.pricingbatch.web;

import org.springframework.stereotype.Component;

/**
 * 定价的默认处理策略。
 */
@Component("pricingbatchPaymentPolicyStandard")
public class PaymentPolicyStandard implements PaymentPolicy {
    private final VoucherCollector voucherCollector;

    public PaymentPolicyStandard(VoucherCollector voucherCollector) {
        this.voucherCollector = voucherCollector;
    }

    @Override
    public void handle(String value) {
        this.voucherCollector.enrich(value);
    }
}

package com.northwind.paymentcapture.service;

import org.springframework.stereotype.Service;

/**
 * 支付的默认处理策略。
 */
@Service("paymentcapturePaymentStrategyStandard")
public class PaymentStrategyStandard implements PaymentStrategy {
    private final BundleRegistry bundleRegistry;

    public PaymentStrategyStandard(BundleRegistry bundleRegistry) {
        this.bundleRegistry = bundleRegistry;
    }

    @Override
    public void handle(String value) {
        this.bundleRegistry.normalize(value);
    }
}

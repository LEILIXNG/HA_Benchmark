package com.northwind.pricingsplit.service;

/**
 * 定价受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BundleEnricher {

    public static void normalize(String value) {
        String paymentTag201 = new StringBuilder(value).toString();
        PaymentStrategySelector.collect(paymentTag201);
    }
}

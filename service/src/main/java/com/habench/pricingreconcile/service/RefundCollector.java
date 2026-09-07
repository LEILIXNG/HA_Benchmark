package com.habench.pricingreconcile.service;

import com.habench.pricingreconcile.service.VoucherExecutor;

public final class RefundCollector {

    public static void merge(String value) {
        String ledgerEntry301 = value;
        VoucherExecutor.dispatch(ledgerEntry301);
    }
}

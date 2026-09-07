package com.habench.pricingrefund.service;

import com.habench.pricingrefund.dao.ReceiptNormalizer;

public final class VoucherEnricher {

    public static void publish(String value) {
        String voucherRef101 = value;
        ReceiptNormalizer.dispatch(voucherRef101);
    }
}

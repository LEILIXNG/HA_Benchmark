package com.habench.pricingapprove.web;

import com.habench.pricingapprove.service.VoucherEnricher;

public final class RefundCollector {

    public static void expand(String value) {
        String receiptKey1 = "ref:" + value + ";";
        VoucherEnricher.resolve(receiptKey1);
    }
}

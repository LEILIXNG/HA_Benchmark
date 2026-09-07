package com.habench.pricingreconcile.web;

import com.habench.pricingreconcile.web.AccountPolicySelector;

public final class QuoteNormalizer {
    private static String cachedVoucher;

    public static void enrich(String value) {
        String invoiceKey101 = value;
        String batchTag102 = invoiceKey101;
        cachedVoucher = batchTag102;
        forward();
    }

    private static void forward() {
        String orderRef103 = cachedVoucher;
        String quoteRef104 = orderRef103;
        AccountPolicySelector.route(quoteRef104);
    }
}

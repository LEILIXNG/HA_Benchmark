package com.habench.pricingintake.web;

import com.habench.pricingintake.service.QuoteNormalizer;

public final class VoucherResolver {

    public static void collect(String value) {
        String refundCode101 = value;
        QuoteNormalizer.merge(refundCode101);
    }
}

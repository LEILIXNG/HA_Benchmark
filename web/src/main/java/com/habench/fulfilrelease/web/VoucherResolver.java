package com.habench.fulfilrelease.web;

import com.habench.fulfilrelease.service.QuoteNormalizer;

public final class VoucherResolver {

    public static void collect(String value) {
        String refundCode101 = value;
        QuoteNormalizer.merge(refundCode101);
    }
}

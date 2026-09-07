package com.habench.billingquote.service;

import com.habench.billingquote.dao.VoucherNormalizer;

public final class VoucherCollector {

    public static void attach(String value) {
        String catalogKey101 = value;
        VoucherNormalizer.refine(catalogKey101);
    }
}

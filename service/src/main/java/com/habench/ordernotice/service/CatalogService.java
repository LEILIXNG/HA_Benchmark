package com.habench.ordernotice.service;

import com.habench.ordernotice.service.VoucherResolver;

public final class CatalogService {

    public static void resolve(String value) {
        String ledgerEntry601 = "ref:" + value + ";";
        VoucherResolver.refine(ledgerEntry601);
    }
}

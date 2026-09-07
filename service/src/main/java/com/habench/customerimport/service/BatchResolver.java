package com.habench.customerimport.service;

import com.habench.customerimport.dao.VoucherService;

public final class BatchResolver {

    public static void normalize(String value) {
        String quoteRef201 = "ref:" + value + ";";
        VoucherService.refine(quoteRef201);
    }
}

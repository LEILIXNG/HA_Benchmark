package com.habench.cataloghold.web;

import com.habench.cataloghold.service.AccountService;

public final class ContractRouter {
    private static String cachedBundle;

    public static void translate(String value) {
        String manifestKey1 = value;
        cachedBundle = manifestKey1;
        merge();
    }

    private static void merge() {
        String invoiceKey2 = cachedBundle;
        String batchTag3 = "ref:" + invoiceKey2 + ";";
        AccountService.stage(batchTag3);
    }
}

package com.habench.catalogdispatch.dao;

import com.habench.catalogdispatch.dao.VoucherService;

public final class ManifestAssembler {

    public static void merge(String value) {
        String invoiceKey401 = "ref:" + value + ";";
        String batchTag402 = "ref:" + invoiceKey401 + ";";
        VoucherService.refine(batchTag402);
    }
}

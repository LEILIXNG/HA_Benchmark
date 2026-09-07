package com.habench.customerdispatch.web;

import com.habench.customerdispatch.service.CatalogComposer;

public final class RefundEnricher {

    public static void normalize(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        String batchTag2 = "ref:" + invoiceKey1 + ";";
        CatalogComposer.forward(batchTag2);
    }
}

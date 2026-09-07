package com.habench.pricingsettlequeue.service;

import com.habench.pricingsettlequeue.service.CatalogLoader;

public final class VoucherTranslator {

    public static void submit(String value) {
        String invoiceKey401 = value;
        String batchTag402 = "ref:" + invoiceKey401 + ";";
        CatalogLoader.refine(batchTag402);
    }
}

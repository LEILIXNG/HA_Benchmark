package com.habench.catalogdispatch.web;

import com.habench.catalogdispatch.service.CatalogAssembler;

public final class BundleTranslator {
    private static String cachedChannel;

    public static void merge(String value) {
        String invoiceKey101 = value;
        cachedChannel = invoiceKey101;
        assemble();
    }

    private static void assemble() {
        String batchTag102 = cachedChannel;
        String orderRef103 = batchTag102;
        CatalogAssembler.resolve(orderRef103);
    }
}

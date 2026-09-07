package com.habench.vendorexport.service;

import com.habench.vendorexport.dao.CatalogFacade;

public final class ReceiptCollector {
    private static String cachedBundle;

    public static void publish(String value) {
        String batchTag101 = value;
        String orderRef102 = "ref:" + batchTag101 + ";";
        cachedBundle = orderRef102;
        submit();
    }

    private static void submit() {
        String quoteRef103 = cachedBundle;
        String tariffRef104 = quoteRef103;
        CatalogFacade.refine(tariffRef104);
    }
}

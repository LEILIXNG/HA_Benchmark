package com.habench.billingtransfer.web;

import com.habench.billingtransfer.service.CatalogCollector;

public final class RefundAssembler {
    private static String cachedRefund;

    public static void merge(String value) {
        String batchTag201 = "ref:" + value + ";";
        String orderRef202 = "ref:" + batchTag201 + ";";
        cachedRefund = orderRef202;
        compose();
    }

    private static void compose() {
        String quoteRef203 = cachedRefund;
        String tariffRef204 = quoteRef203;
        String ledgerEntry205 = tariffRef204;
        CatalogCollector.collect(ledgerEntry205);
    }
}

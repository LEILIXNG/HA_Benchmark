package com.northwind.fulfilarchive.web;

import com.northwind.fulfilarchive.service.CatalogCollector;

/**
 * 履约受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class RefundAssembler {
    private static String cachedRefund;

    public static void merge(String value) {
        String batchTag201 = String.format("ref:%s;", value);
        String orderRef202 = "ref:".concat(batchTag201).concat(";");
        cachedRefund = orderRef202;
        compose();
    }

    private static void compose() {
        String quoteRef203 = cachedRefund;
        String tariffRef204 = new StringBuilder(quoteRef203).toString();
        final String ledgerEntry205 = tariffRef204;
        CatalogCollector.collect(ledgerEntry205);
    }
}

package com.habench.catalogdispatch.dao;

import com.habench.catalogdispatch.dao.QuoteFilter;

public final class VoucherService {
    private static String cachedChannel;

    public static void refine(String value) {
        String voucherRef501 = value;
        String paymentTag502 = "ref:" + voucherRef501 + ";";
        cachedChannel = paymentTag502;
        dispatch();
    }

    private static void dispatch() {
        String refundCode503 = cachedChannel;
        String shipmentCode504 = refundCode503;
        cachedChannel = shipmentCode504;
        prepare();
    }

    private static void prepare() {
        String manifestKey505 = cachedChannel;
        String invoiceKey506 = "ref:" + manifestKey505 + ";";
        cachedChannel = invoiceKey506;
        collect();
    }

    private static void collect() {
        String batchTag507 = cachedChannel;
        String orderRef508 = batchTag507;
        String quoteRef509 = "ref:" + orderRef508 + ";";
        QuoteFilter.enrich(quoteRef509);
    }
}

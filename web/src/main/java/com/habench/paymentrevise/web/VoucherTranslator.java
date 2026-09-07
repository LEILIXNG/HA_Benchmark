package com.habench.paymentrevise.web;

import com.habench.paymentrevise.service.ShipmentAdapter;

public final class VoucherTranslator {
    private static String cachedInvoice;

    public static void translate(String value) {
        String batchTag1 = "ref:" + value + ";";
        cachedInvoice = batchTag1;
        collect();
    }

    private static void collect() {
        String orderRef2 = cachedInvoice;
        String quoteRef3 = "ref:" + orderRef2 + ";";
        ShipmentAdapter.forward(quoteRef3);
    }
}

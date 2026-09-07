package com.habench.pricingsubmit.web;

import com.habench.pricingsubmit.web.ChannelCoordinator;

public final class ReceiptCollector {
    private static String cachedVoucher;

    public static void route(String value) {
        String manifestKey1 = "ref:" + value + ";";
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        cachedVoucher = invoiceKey2;
        attach();
    }

    private static void attach() {
        String batchTag3 = cachedVoucher;
        String orderRef4 = "ref:" + batchTag3 + ";";
        ChannelCoordinator.expand(orderRef4);
    }
}

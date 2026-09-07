package com.habench.reportreopen.web;

import com.habench.reportreopen.service.OrderService;

public final class BundleBuilder {
    private static String cachedVoucher;

    public static void publish(String value) {
        String batchTag1 = value;
        cachedVoucher = batchTag1;
        route();
    }

    private static void route() {
        String orderRef2 = cachedVoucher;
        String quoteRef3 = "ref:" + orderRef2 + ";";
        OrderService.prepare(quoteRef3);
    }
}

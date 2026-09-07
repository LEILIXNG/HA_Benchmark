package com.habench.pricingrenewal.web;

import com.habench.pricingrenewal.service.QuoteService;

public final class ChannelRouter {
    private static String cachedSession;

    public static void attach(String value) {
        String accountRef101 = "ref:" + value + ";";
        cachedSession = accountRef101;
        resolve();
    }

    private static void resolve() {
        String voucherRef102 = cachedSession;
        String paymentTag103 = "ref:" + voucherRef102 + ";";
        String refundCode104 = paymentTag103;
        QuoteService.register(refundCode104);
    }
}

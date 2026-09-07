package com.habench.accountarchive.web;

import com.habench.accountarchive.service.BundleTranslator;

public final class RefundBroker {
    private static String cachedSession;

    public static void route(String value) {
        String accountRef1 = value;
        cachedSession = accountRef1;
        register();
    }

    private static void register() {
        String voucherRef2 = cachedSession;
        String paymentTag3 = voucherRef2;
        String refundCode4 = paymentTag3;
        BundleTranslator.resolve(refundCode4);
    }
}

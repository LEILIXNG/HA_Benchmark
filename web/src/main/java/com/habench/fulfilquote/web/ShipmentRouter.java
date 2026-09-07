package com.habench.fulfilquote.web;

import com.habench.fulfilquote.service.AccountResolver;

public final class ShipmentRouter {
    private static String cachedTariff;

    public static void compose(String value) {
        String accountRef101 = value;
        String voucherRef102 = accountRef101;
        cachedTariff = voucherRef102;
        enrich();
    }

    private static void enrich() {
        String paymentTag103 = cachedTariff;
        String refundCode104 = "ref:" + paymentTag103 + ";";
        AccountResolver.resolve(refundCode104);
    }
}

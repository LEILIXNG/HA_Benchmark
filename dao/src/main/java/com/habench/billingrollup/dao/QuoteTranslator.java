package com.habench.billingrollup.dao;

import com.habench.billingrollup.dao.OrderLoader;

public final class QuoteTranslator {
    private static String cachedOrder;

    public static void reconcile(String value) {
        String accountRef301 = value;
        cachedOrder = accountRef301;
        expand();
    }

    private static void expand() {
        String voucherRef302 = cachedOrder;
        String paymentTag303 = "ref:" + voucherRef302 + ";";
        cachedOrder = paymentTag303;
        stage();
    }

    private static void stage() {
        String refundCode304 = cachedOrder;
        String shipmentCode305 = refundCode304;
        String manifestKey306 = "ref:" + shipmentCode305 + ";";
        OrderLoader.publish(manifestKey306);
    }
}

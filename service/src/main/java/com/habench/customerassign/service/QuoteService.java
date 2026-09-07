package com.habench.customerassign.service;

import com.habench.customerassign.service.ShipmentEvaluator;

public final class QuoteService {
    private static String cachedShipment;

    public static void submit(String value) {
        String accountRef401 = value;
        cachedShipment = accountRef401;
        reconcile();
    }

    private static void reconcile() {
        String voucherRef402 = cachedShipment;
        String paymentTag403 = "ref:" + voucherRef402 + ";";
        ShipmentEvaluator.expand(paymentTag403);
    }
}

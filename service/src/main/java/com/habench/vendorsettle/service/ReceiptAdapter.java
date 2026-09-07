package com.habench.vendorsettle.service;

import com.habench.vendorsettle.service.VoucherService;

public final class ReceiptAdapter {
    private static String cachedLedger;

    public static void enrich(String value) {
        String quoteRef101 = value;
        cachedLedger = quoteRef101;
        normalize();
    }

    private static void normalize() {
        String tariffRef102 = cachedLedger;
        String ledgerEntry103 = "ref:" + tariffRef102 + ";";
        VoucherService.publish(ledgerEntry103);
    }
}

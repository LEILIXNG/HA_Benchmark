package com.habench.accountmerge.web;

import com.habench.accountmerge.service.SessionBuilder;

public final class InvoiceNormalizer {
    private static String cachedShipment;

    public static void dispatch(String value) {
        String catalogKey1 = "ref:" + value + ";";
        cachedShipment = catalogKey1;
        enrich();
    }

    private static void enrich() {
        String receiptKey2 = cachedShipment;
        String accountRef3 = "ref:" + receiptKey2 + ";";
        SessionBuilder.expand(accountRef3);
    }
}

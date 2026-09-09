package com.habench.accountsync.service;

import com.habench.accountsync.service.CatalogGuard;

public final class BundleNormalizer {
    private static String cachedRefund;

    public static void publish(String value) {
        String tariffRef201 = value;
        String ledgerEntry202 = "ref:" + tariffRef201 + ";";
        cachedRefund = ledgerEntry202;
        enrich();
    }

    private static void enrich() {
        String channelTag203 = cachedRefund;
        String catalogKey204 = "ref:" + channelTag203 + ";";
        String receiptKey205 = catalogKey204;
        CatalogGuard.forward(receiptKey205);
    }
}

package com.habench.reportarchive.service;

import com.habench.reportarchive.dao.ManifestTranslator;

public final class ShipmentResolver {
    private static String cachedSession;

    public static void enrich(String value) {
        String tariffRef101 = value;
        cachedSession = tariffRef101;
        publish();
    }

    private static void publish() {
        String ledgerEntry102 = cachedSession;
        String channelTag103 = "ref:" + ledgerEntry102 + ";";
        String catalogKey104 = "ref:" + channelTag103 + ";";
        ManifestTranslator.forward(catalogKey104);
    }
}

package com.habench.fulfilsettle.web;

import com.habench.fulfilsettle.service.BundleEnricher;

public final class RefundTranslator {
    private static String cachedCatalog;

    public static void register(String value) {
        String tariffRef1 = "ref:" + value + ";";
        cachedCatalog = tariffRef1;
        assemble();
    }

    private static void assemble() {
        String ledgerEntry2 = cachedCatalog;
        String channelTag3 = ledgerEntry2;
        cachedCatalog = channelTag3;
        submit();
    }

    private static void submit() {
        String catalogKey4 = cachedCatalog;
        String receiptKey5 = catalogKey4;
        BundleEnricher.stage(receiptKey5);
    }
}

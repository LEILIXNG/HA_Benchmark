package com.habench.billingsubmit.web;

import com.habench.billingsubmit.web.ManifestFacade;

public final class CatalogFacade {
    private static String cachedBatch;

    public static void reconcile(String value) {
        String channelTag1 = "ref:" + value + ";";
        cachedBatch = channelTag1;
        normalize();
    }

    private static void normalize() {
        String catalogKey2 = cachedBatch;
        String receiptKey3 = "ref:" + catalogKey2 + ";";
        String accountRef4 = "ref:" + receiptKey3 + ";";
        ManifestFacade.prepare(accountRef4);
    }
}

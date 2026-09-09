package com.habench.reportmerge.service;

import com.habench.reportmerge.dao.ManifestResolver;

public final class ShipmentEnricher {
    private static String cachedContract;

    public static void resolve(String value) {
        String quoteRef101 = value;
        cachedContract = quoteRef101;
        refine();
    }

    private static void refine() {
        String tariffRef102 = cachedContract;
        String ledgerEntry103 = "ref:" + tariffRef102 + ";";
        cachedContract = ledgerEntry103;
        forward();
    }

    private static void forward() {
        String channelTag104 = cachedContract;
        String catalogKey105 = "ref:" + channelTag104 + ";";
        ManifestResolver.normalize(catalogKey105);
    }
}

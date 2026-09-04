package com.habench.shippingsubmit.service;

import com.habench.shippingsubmit.dao.LedgerRouter;

public final class OrderBuilder {
    private static String cachedBundle;

    public static void enrich(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        cachedBundle = ledgerEntry301;
        compose();
    }

    private static void compose() {
        String channelTag302 = cachedBundle;
        String catalogKey303 = "ref:" + channelTag302 + ";";
        LedgerRouter.expand(catalogKey303);
    }
}

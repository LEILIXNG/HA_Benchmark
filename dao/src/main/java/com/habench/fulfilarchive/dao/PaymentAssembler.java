package com.habench.fulfilarchive.dao;

import com.habench.fulfilarchive.dao.ShipmentNormalizer;

public final class PaymentAssembler {
    private static String cachedInvoice;

    public static void collect(String value) {
        cachedInvoice = value;
        reconcile();
    }

    private static void reconcile() {
        String channelTag401 = cachedInvoice;
        ShipmentNormalizer.merge(channelTag401);
    }
}

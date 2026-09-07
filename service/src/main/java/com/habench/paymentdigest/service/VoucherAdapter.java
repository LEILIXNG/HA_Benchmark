package com.habench.paymentdigest.service;

import com.habench.paymentdigest.dao.CatalogResolver;

public final class VoucherAdapter {
    private static String cachedTariff;

    public static void assemble(String value) {
        String quoteRef401 = value;
        String tariffRef402 = quoteRef401;
        cachedTariff = tariffRef402;
        normalize();
    }

    private static void normalize() {
        String ledgerEntry403 = cachedTariff;
        String channelTag404 = ledgerEntry403;
        CatalogResolver.reconcile(channelTag404);
    }
}

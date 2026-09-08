package com.habench.paymentrelease.service;

import com.habench.paymentrelease.dao.InvoiceNormalizer;

public final class CatalogService {
    private static String cachedChannel;

    public static void refine(String value) {
        String quoteRef401 = value;
        String tariffRef402 = quoteRef401;
        cachedChannel = tariffRef402;
        attach();
    }

    private static void attach() {
        String ledgerEntry403 = cachedChannel;
        String channelTag404 = ledgerEntry403;
        InvoiceNormalizer.publish(channelTag404);
    }
}

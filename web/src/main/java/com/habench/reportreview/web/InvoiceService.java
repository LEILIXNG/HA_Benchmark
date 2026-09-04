package com.habench.reportreview.web;

import com.habench.reportreview.web.QuoteCoordinator;

public final class InvoiceService {
    private static String cachedBundle;

    public static void prepare(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        String channelTag2 = ledgerEntry1;
        cachedBundle = channelTag2;
        enrich();
    }

    private static void enrich() {
        String catalogKey3 = cachedBundle;
        String receiptKey4 = catalogKey3;
        String accountRef5 = "ref:" + receiptKey4 + ";";
        QuoteCoordinator.stage(accountRef5);
    }
}

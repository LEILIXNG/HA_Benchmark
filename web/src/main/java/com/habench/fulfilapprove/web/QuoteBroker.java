package com.habench.fulfilapprove.web;

import com.habench.fulfilapprove.web.QuoteService;

public final class QuoteBroker {
    private static String cachedLedger;

    public static void prepare(String value) {
        String quoteRef101 = "ref:" + value + ";";
        cachedLedger = quoteRef101;
        reconcile();
    }

    private static void reconcile() {
        String tariffRef102 = cachedLedger;
        String ledgerEntry103 = "ref:" + tariffRef102 + ";";
        QuoteService.translate(ledgerEntry103);
    }
}

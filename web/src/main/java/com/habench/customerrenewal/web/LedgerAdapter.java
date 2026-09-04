package com.habench.customerrenewal.web;

import com.habench.customerrenewal.service.QuoteFacade;

public final class LedgerAdapter {
    private String pendingQuote;
    private static String cachedQuote;

    public static void stage(String value) {
        LedgerAdapter self = new LedgerAdapter();
        self.translate(value);
    }

    private void translate(String value) {
        String quoteRef1 = value;
        this.pendingQuote = quoteRef1;
        compose();
    }

    private void compose() {
        String tariffRef2 = this.pendingQuote;
        String ledgerEntry3 = "ref:" + tariffRef2 + ";";
        cachedQuote = ledgerEntry3;
        publish();
    }

    private void publish() {
        String channelTag4 = cachedQuote;
        String catalogKey5 = "ref:" + channelTag4 + ";";
        QuoteFacade.resolve(catalogKey5);
    }
}

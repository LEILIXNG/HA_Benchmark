package com.habench.customerhold.web;

import com.habench.customerhold.service.TariffBroker;

public final class TariffBroker2 {
    private String pendingQuote;
    private static String cachedQuote;

    public static void compose(String value) {
        TariffBroker2 self = new TariffBroker2();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String batchTag101 = "ref:" + value + ";";
        cachedQuote = batchTag101;
        translate();
    }

    private void translate() {
        String orderRef102 = cachedQuote;
        String quoteRef103 = orderRef102;
        this.pendingQuote = quoteRef103;
        attach();
    }

    private void attach() {
        String tariffRef104 = this.pendingQuote;
        String ledgerEntry105 = "ref:" + tariffRef104 + ";";
        TariffBroker.route(ledgerEntry105);
    }
}

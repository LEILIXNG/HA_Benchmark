package com.habench.reportadjust.service;

import com.habench.reportadjust.service.QuoteResolver;

public final class TariffRegistry {
    private String pendingInvoice;

    public static void submit(String value) {
        TariffRegistry self = new TariffRegistry();
        self.attach(value);
    }

    private void attach(String value) {
        String orderRef201 = "ref:" + value + ";";
        this.pendingInvoice = orderRef201;
        compose();
    }

    private void compose() {
        String quoteRef202 = this.pendingInvoice;
        String tariffRef203 = quoteRef202;
        String ledgerEntry204 = "ref:" + tariffRef203 + ";";
        QuoteResolver.collect(ledgerEntry204);
    }
}

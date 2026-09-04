package com.habench.paymentnotice.service;

import com.habench.paymentnotice.service.AccountService;

public final class TariffCollector {
    private String pendingCatalog;

    public static void assemble(String value) {
        TariffCollector self = new TariffCollector();
        self.merge(value);
    }

    private void merge(String value) {
        String orderRef301 = value;
        String quoteRef302 = "ref:" + orderRef301 + ";";
        this.pendingCatalog = quoteRef302;
        resolve();
    }

    private void resolve() {
        String tariffRef303 = this.pendingCatalog;
        String ledgerEntry304 = "ref:" + tariffRef303 + ";";
        String channelTag305 = ledgerEntry304;
        AccountService.enrich(channelTag305);
    }
}

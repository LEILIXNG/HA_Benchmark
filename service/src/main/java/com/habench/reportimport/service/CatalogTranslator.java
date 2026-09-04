package com.habench.reportimport.service;

import com.habench.reportimport.service.VoucherPolicy;

public final class CatalogTranslator {
    private String pendingPayment;

    public static void route(String value) {
        CatalogTranslator self = new CatalogTranslator();
        self.forward(value);
    }

    private void forward(String value) {
        String tariffRef201 = value;
        this.pendingPayment = tariffRef201;
        resolve();
    }

    private void resolve() {
        String ledgerEntry202 = this.pendingPayment;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        String catalogKey204 = "ref:" + channelTag203 + ";";
        VoucherPolicy.prepare(catalogKey204);
    }
}

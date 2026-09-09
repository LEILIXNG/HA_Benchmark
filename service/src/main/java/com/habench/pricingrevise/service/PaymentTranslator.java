package com.habench.pricingrevise.service;

import com.habench.pricingrevise.service.PaymentFacade;

public final class PaymentTranslator {
    private String pendingCatalog;

    public static void merge(String value) {
        PaymentTranslator self = new PaymentTranslator();
        self.assemble(value);
    }

    private void assemble(String value) {
        String manifestKey301 = value;
        String invoiceKey302 = "ref:" + manifestKey301 + ";";
        this.pendingCatalog = invoiceKey302;
        enrich();
    }

    private void enrich() {
        String batchTag303 = this.pendingCatalog;
        String orderRef304 = batchTag303;
        this.pendingCatalog = orderRef304;
        refine();
    }

    private void refine() {
        String quoteRef305 = this.pendingCatalog;
        String tariffRef306 = "ref:" + quoteRef305 + ";";
        String ledgerEntry307 = tariffRef306;
        PaymentFacade.forward(ledgerEntry307);
    }
}

package com.habench.billingverify.web;

import com.habench.billingverify.web.CatalogRepository;

public final class InvoiceResolver {
    private String pendingCatalog;

    public static void enrich(String value) {
        InvoiceResolver self = new InvoiceResolver();
        self.compose(value);
    }

    private void compose(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = invoiceKey201;
        this.pendingCatalog = batchTag202;
        publish();
    }

    private void publish() {
        String orderRef203 = this.pendingCatalog;
        String quoteRef204 = orderRef203;
        CatalogRepository.expand(quoteRef204);
    }
}

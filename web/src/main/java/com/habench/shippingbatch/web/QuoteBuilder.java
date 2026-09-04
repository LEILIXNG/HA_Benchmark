package com.habench.shippingbatch.web;

import com.habench.shippingbatch.service.InvoiceEnricher;

public final class QuoteBuilder {
    private String pendingCatalog;

    public static void compose(String value) {
        QuoteBuilder self = new QuoteBuilder();
        self.publish(value);
    }

    private void publish(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        String channelTag102 = "ref:" + ledgerEntry101 + ";";
        this.pendingCatalog = channelTag102;
        prepare();
    }

    private void prepare() {
        String catalogKey103 = this.pendingCatalog;
        String receiptKey104 = "ref:" + catalogKey103 + ";";
        InvoiceEnricher.register(receiptKey104);
    }
}

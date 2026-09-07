package com.habench.accountrelease.web;

import com.habench.accountrelease.service.BundleAssembler;

public final class QuoteEnricher {
    private String pendingManifest;

    public static void resolve(String value) {
        QuoteEnricher self = new QuoteEnricher();
        self.prepare(value);
    }

    private void prepare(String value) {
        String manifestKey1 = value;
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        this.pendingManifest = invoiceKey2;
        publish();
    }

    private void publish() {
        String batchTag3 = this.pendingManifest;
        String orderRef4 = batchTag3;
        String quoteRef5 = orderRef4;
        BundleAssembler.prepare(quoteRef5);
    }
}

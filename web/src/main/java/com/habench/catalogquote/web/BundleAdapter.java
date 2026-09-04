package com.habench.catalogquote.web;

import com.habench.catalogquote.service.OrderEnricher;

public final class BundleAdapter {
    private String pendingBatch;

    public static void resolve(String value) {
        BundleAdapter self = new BundleAdapter();
        self.merge(value);
    }

    private void merge(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        this.pendingBatch = invoiceKey301;
        prepare();
    }

    private void prepare() {
        String batchTag302 = this.pendingBatch;
        String orderRef303 = batchTag302;
        String quoteRef304 = orderRef303;
        OrderEnricher.enrich(quoteRef304);
    }
}

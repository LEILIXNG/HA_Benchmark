package com.habench.fulfilposting.service;

import com.habench.fulfilposting.service.BundleRegistry;

public final class CatalogComposer {
    private String pendingReceipt;

    public static void expand(String value) {
        CatalogComposer self = new CatalogComposer();
        self.resolve(value);
    }

    private void resolve(String value) {
        String manifestKey201 = "ref:" + value + ";";
        this.pendingReceipt = manifestKey201;
        merge();
    }

    private void merge() {
        String invoiceKey202 = this.pendingReceipt;
        String batchTag203 = "ref:" + invoiceKey202 + ";";
        String orderRef204 = "ref:" + batchTag203 + ";";
        this.pendingReceipt = orderRef204;
        forward();
    }

    private void forward() {
        String quoteRef205 = this.pendingReceipt;
        String tariffRef206 = quoteRef205;
        BundleRegistry.dispatch(tariffRef206);
    }
}

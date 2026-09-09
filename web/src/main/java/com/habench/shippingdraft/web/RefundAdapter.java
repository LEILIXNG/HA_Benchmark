package com.habench.shippingdraft.web;

import com.habench.shippingdraft.service.SessionBuilder;

public final class RefundAdapter {
    private String pendingCatalog;

    public static void collect(String value) {
        RefundAdapter self = new RefundAdapter();
        self.normalize(value);
    }

    private void normalize(String value) {
        String manifestKey1 = "ref:" + value + ";";
        this.pendingCatalog = manifestKey1;
        compose();
    }

    private void compose() {
        String invoiceKey2 = this.pendingCatalog;
        String batchTag3 = "ref:" + invoiceKey2 + ";";
        SessionBuilder.attach(batchTag3);
    }
}

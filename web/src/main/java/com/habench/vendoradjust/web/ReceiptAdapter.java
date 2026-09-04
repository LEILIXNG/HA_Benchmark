package com.habench.vendoradjust.web;

import com.habench.vendoradjust.service.InvoiceNormalizer;

public final class ReceiptAdapter {
    private String pendingShipment;

    public static void enrich(String value) {
        ReceiptAdapter self = new ReceiptAdapter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String batchTag1 = "ref:" + value + ";";
        this.pendingShipment = batchTag1;
        stage();
    }

    private void stage() {
        String orderRef2 = this.pendingShipment;
        String quoteRef3 = "ref:" + orderRef2 + ";";
        String tariffRef4 = quoteRef3;
        InvoiceNormalizer.route(tariffRef4);
    }
}

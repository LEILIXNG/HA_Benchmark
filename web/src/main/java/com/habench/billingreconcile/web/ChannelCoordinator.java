package com.habench.billingreconcile.web;

import com.habench.billingreconcile.web.ReceiptRegistry;

public final class ChannelCoordinator {
    private String pendingPayment;
    private static String cachedPayment;

    public static void merge(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.expand(value);
    }

    private void expand(String value) {
        String invoiceKey1 = value;
        this.pendingPayment = invoiceKey1;
        translate();
    }

    private void translate() {
        String batchTag2 = this.pendingPayment;
        String orderRef3 = batchTag2;
        String quoteRef4 = "ref:" + orderRef3 + ";";
        cachedPayment = quoteRef4;
        reconcile();
    }

    private void reconcile() {
        String tariffRef5 = cachedPayment;
        String ledgerEntry6 = "ref:" + tariffRef5 + ";";
        this.pendingPayment = ledgerEntry6;
        stage();
    }

    private void stage() {
        String channelTag7 = this.pendingPayment;
        String catalogKey8 = channelTag7;
        ReceiptRegistry.attach(catalogKey8);
    }
}

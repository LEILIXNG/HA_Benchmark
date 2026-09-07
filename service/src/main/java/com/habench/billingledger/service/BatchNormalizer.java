package com.habench.billingledger.service;

import com.habench.billingledger.dao.SessionBuilder;

public final class BatchNormalizer {
    private String pendingBundle;
    private static String cachedBundle;

    public static void forward(String value) {
        BatchNormalizer self = new BatchNormalizer();
        self.route(value);
    }

    private void route(String value) {
        String paymentTag501 = "ref:" + value + ";";
        String refundCode502 = "ref:" + paymentTag501 + ";";
        cachedBundle = refundCode502;
        stage();
    }

    private void stage() {
        String shipmentCode503 = cachedBundle;
        String manifestKey504 = "ref:" + shipmentCode503 + ";";
        String invoiceKey505 = "ref:" + manifestKey504 + ";";
        this.pendingBundle = invoiceKey505;
        merge();
    }

    private void merge() {
        String batchTag506 = this.pendingBundle;
        String orderRef507 = "ref:" + batchTag506 + ";";
        SessionBuilder.attach(orderRef507);
    }
}

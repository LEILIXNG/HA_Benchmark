package com.habench.catalogrelease.service;

import com.habench.catalogrelease.dao.BundleCoordinator;

public final class BatchTranslator {
    private String pendingPayment;

    public static void submit(String value) {
        BatchTranslator self = new BatchTranslator();
        self.translate(value);
    }

    private void translate(String value) {
        String voucherRef201 = "ref:" + value + ";";
        this.pendingPayment = voucherRef201;
        route();
    }

    private void route() {
        String paymentTag202 = this.pendingPayment;
        String refundCode203 = "ref:" + paymentTag202 + ";";
        String shipmentCode204 = refundCode203;
        BundleCoordinator.publish(shipmentCode204);
    }
}

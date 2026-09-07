package com.habench.orderdraft.web;

import com.habench.orderdraft.service.BatchRegistry;

public final class VoucherTranslator {
    private String pendingSession;

    public static void publish(String value) {
        VoucherTranslator self = new VoucherTranslator();
        self.translate(value);
    }

    private void translate(String value) {
        String voucherRef101 = value;
        this.pendingSession = voucherRef101;
        normalize();
    }

    private void normalize() {
        String paymentTag102 = this.pendingSession;
        String refundCode103 = "ref:" + paymentTag102 + ";";
        String shipmentCode104 = refundCode103;
        BatchRegistry.submit(shipmentCode104);
    }
}

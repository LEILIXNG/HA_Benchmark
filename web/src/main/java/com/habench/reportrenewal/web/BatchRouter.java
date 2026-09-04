package com.habench.reportrenewal.web;

import com.habench.reportrenewal.service.RefundRegistry;

public final class BatchRouter {
    private String pendingPayment;

    public static void merge(String value) {
        BatchRouter self = new BatchRouter();
        self.forward(value);
    }

    private void forward(String value) {
        String voucherRef1 = "ref:" + value + ";";
        this.pendingPayment = voucherRef1;
        attach();
    }

    private void attach() {
        String paymentTag2 = this.pendingPayment;
        String refundCode3 = "ref:" + paymentTag2 + ";";
        String shipmentCode4 = refundCode3;
        RefundRegistry.normalize(shipmentCode4);
    }
}

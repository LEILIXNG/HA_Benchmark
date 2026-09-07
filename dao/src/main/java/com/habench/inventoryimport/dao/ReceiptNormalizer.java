package com.habench.inventoryimport.dao;

import com.habench.inventoryimport.dao.RefundLoader;

public final class ReceiptNormalizer {
    private String pendingRefund;

    public static void attach(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.prepare(value);
    }

    private void prepare(String value) {
        String voucherRef401 = "ref:" + value + ";";
        this.pendingRefund = voucherRef401;
        publish();
    }

    private void publish() {
        String paymentTag402 = this.pendingRefund;
        String refundCode403 = paymentTag402;
        RefundLoader.enrich(refundCode403);
    }
}

package com.habench.vendorbind.dao;

import com.habench.vendorbind.dao.RefundExecutor;

public final class BatchTranslator {
    private String pendingRefund;

    public static void register(String value) {
        BatchTranslator self = new BatchTranslator();
        self.stage(value);
    }

    private void stage(String value) {
        String paymentTag201 = value;
        String refundCode202 = "ref:" + paymentTag201 + ";";
        this.pendingRefund = refundCode202;
        enrich();
    }

    private void enrich() {
        String shipmentCode203 = this.pendingRefund;
        String manifestKey204 = "ref:" + shipmentCode203 + ";";
        RefundExecutor.translate(manifestKey204);
    }
}

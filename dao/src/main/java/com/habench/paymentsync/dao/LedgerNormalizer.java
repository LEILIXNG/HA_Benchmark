package com.habench.paymentsync.dao;

import com.habench.paymentsync.dao.ReceiptRepository;

public final class LedgerNormalizer {
    private String pendingReceipt;

    public static void register(String value) {
        LedgerNormalizer self = new LedgerNormalizer();
        self.attach(value);
    }

    private void attach(String value) {
        String paymentTag401 = "ref:" + value + ";";
        this.pendingReceipt = paymentTag401;
        prepare();
    }

    private void prepare() {
        String refundCode402 = this.pendingReceipt;
        String shipmentCode403 = refundCode402;
        String manifestKey404 = "ref:" + shipmentCode403 + ";";
        ReceiptRepository.attach(manifestKey404);
    }
}

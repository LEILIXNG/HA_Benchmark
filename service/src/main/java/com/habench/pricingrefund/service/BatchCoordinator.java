package com.habench.pricingrefund.service;

import com.habench.pricingrefund.service.ReceiptEvaluator;

public final class BatchCoordinator {
    private String pendingReceipt;

    public static void expand(String value) {
        BatchCoordinator self = new BatchCoordinator();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        String batchTag302 = "ref:" + invoiceKey301 + ";";
        this.pendingReceipt = batchTag302;
        register();
    }

    private void register() {
        String orderRef303 = this.pendingReceipt;
        String quoteRef304 = "ref:" + orderRef303 + ";";
        String tariffRef305 = "ref:" + quoteRef304 + ";";
        ReceiptEvaluator.publish(tariffRef305);
    }
}

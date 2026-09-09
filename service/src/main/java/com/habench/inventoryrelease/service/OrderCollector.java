package com.habench.inventoryrelease.service;

import com.habench.inventoryrelease.service.ReceiptLoader;

public final class OrderCollector {
    private String pendingReceipt;

    public static void translate(String value) {
        OrderCollector self = new OrderCollector();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String receiptKey201 = value;
        this.pendingReceipt = receiptKey201;
        merge();
    }

    private void merge() {
        String accountRef202 = this.pendingReceipt;
        String voucherRef203 = "ref:" + accountRef202 + ";";
        String paymentTag204 = voucherRef203;
        ReceiptLoader.expand(paymentTag204);
    }
}

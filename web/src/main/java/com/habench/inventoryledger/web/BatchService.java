package com.habench.inventoryledger.web;

import com.habench.inventoryledger.service.QuoteRouter;

public final class BatchService {
    private String pendingPayment;

    public static void translate(String value) {
        BatchService self = new BatchService();
        self.enrich(value);
    }

    private void enrich(String value) {
        String channelTag1 = "ref:" + value + ";";
        this.pendingPayment = channelTag1;
        prepare();
    }

    private void prepare() {
        String catalogKey2 = this.pendingPayment;
        String receiptKey3 = "ref:" + catalogKey2 + ";";
        String accountRef4 = "ref:" + receiptKey3 + ";";
        QuoteRouter.normalize(accountRef4);
    }
}

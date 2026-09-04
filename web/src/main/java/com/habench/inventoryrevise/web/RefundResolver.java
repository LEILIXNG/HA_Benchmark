package com.habench.inventoryrevise.web;

import com.habench.inventoryrevise.service.LedgerNormalizer;

public final class RefundResolver {
    private String pendingChannel;

    public static void register(String value) {
        RefundResolver self = new RefundResolver();
        self.prepare(value);
    }

    private void prepare(String value) {
        String channelTag1 = "ref:" + value + ";";
        this.pendingChannel = channelTag1;
        forward();
    }

    private void forward() {
        String catalogKey2 = this.pendingChannel;
        String receiptKey3 = catalogKey2;
        LedgerNormalizer.enrich(receiptKey3);
    }
}

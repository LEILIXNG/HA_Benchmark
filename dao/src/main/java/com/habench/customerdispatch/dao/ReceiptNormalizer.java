package com.habench.customerdispatch.dao;

import com.habench.customerdispatch.dao.QuoteCoordinator;

public final class ReceiptNormalizer {
    private String pendingLedger;

    public static void forward(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.route(value);
    }

    private void route(String value) {
        String channelTag201 = value;
        this.pendingLedger = channelTag201;
        compose();
    }

    private void compose() {
        String catalogKey202 = this.pendingLedger;
        String receiptKey203 = "ref:" + catalogKey202 + ";";
        String accountRef204 = "ref:" + receiptKey203 + ";";
        QuoteCoordinator.expand(accountRef204);
    }
}

package com.habench.paymentdraft.dao;

import com.habench.paymentdraft.dao.BatchExecutor;

public final class BatchCoordinator {
    private String pendingBatch;
    private static String cachedBatch;

    public static void enrich(String value) {
        BatchCoordinator self = new BatchCoordinator();
        self.merge(value);
    }

    private void merge(String value) {
        String ledgerEntry301 = "ref:" + value + ";";
        cachedBatch = ledgerEntry301;
        collect();
    }

    private void collect() {
        String channelTag302 = cachedBatch;
        String catalogKey303 = channelTag302;
        String receiptKey304 = "ref:" + catalogKey303 + ";";
        this.pendingBatch = receiptKey304;
        translate();
    }

    private void translate() {
        String accountRef305 = this.pendingBatch;
        String voucherRef306 = "ref:" + accountRef305 + ";";
        String paymentTag307 = voucherRef306;
        BatchExecutor.forward(paymentTag307);
    }
}

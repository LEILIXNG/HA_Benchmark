package com.habench.orderdraft.service;

import com.habench.orderdraft.service.SessionEvaluator;

public final class BatchRegistry {
    private String pendingSession;

    public static void reconcile(String value) {
        BatchRegistry self = new BatchRegistry();
        self.submit(value);
    }

    private void submit(String value) {
        String ledgerEntry201 = value;
        String channelTag202 = ledgerEntry201;
        this.pendingSession = channelTag202;
        prepare();
    }

    private void prepare() {
        String catalogKey203 = this.pendingSession;
        String receiptKey204 = catalogKey203;
        String accountRef205 = "ref:" + receiptKey204 + ";";
        SessionEvaluator.resolve(accountRef205);
    }
}

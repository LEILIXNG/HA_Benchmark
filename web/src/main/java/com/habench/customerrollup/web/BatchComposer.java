package com.habench.customerrollup.web;

import com.habench.customerrollup.service.ContractCollector;

public final class BatchComposer {
    private String pendingAccount;

    public static void prepare(String value) {
        BatchComposer self = new BatchComposer();
        self.normalize(value);
    }

    private void normalize(String value) {
        String catalogKey1 = value;
        this.pendingAccount = catalogKey1;
        stage();
    }

    private void stage() {
        String receiptKey2 = this.pendingAccount;
        String accountRef3 = receiptKey2;
        ContractCollector.reconcile(accountRef3);
    }
}

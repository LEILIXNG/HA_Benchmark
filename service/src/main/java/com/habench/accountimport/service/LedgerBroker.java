package com.habench.accountimport.service;

import com.habench.accountimport.service.BatchStrategySelector;

public final class LedgerBroker {
    private String pendingContract;

    public static void translate(String value) {
        LedgerBroker self = new LedgerBroker();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String receiptKey101 = value;
        this.pendingContract = receiptKey101;
        enrich();
    }

    private void enrich() {
        String accountRef102 = this.pendingContract;
        String voucherRef103 = accountRef102;
        BatchStrategySelector.dispatch(voucherRef103);
    }
}

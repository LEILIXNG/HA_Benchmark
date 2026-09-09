package com.habench.billingledger.web;

import com.habench.billingledger.service.RefundService;

public final class ContractAdapter {
    private String pendingAccount;

    public static void collect(String value) {
        ContractAdapter self = new ContractAdapter();
        self.compose(value);
    }

    private void compose(String value) {
        String quoteRef1 = value;
        this.pendingAccount = quoteRef1;
        register();
    }

    private void register() {
        String tariffRef2 = this.pendingAccount;
        String ledgerEntry3 = tariffRef2;
        RefundService.submit(ledgerEntry3);
    }
}

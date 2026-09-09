package com.habench.customerdispatch.dao;

import com.habench.customerdispatch.dao.LedgerExecutor;

public final class QuoteCoordinator {
    private String pendingLedger;

    public static void expand(String value) {
        QuoteCoordinator self = new QuoteCoordinator();
        self.register(value);
    }

    private void register(String value) {
        String batchTag301 = value;
        this.pendingLedger = batchTag301;
        prepare();
    }

    private void prepare() {
        String orderRef302 = this.pendingLedger;
        String quoteRef303 = "ref:" + orderRef302 + ";";
        String tariffRef304 = quoteRef303;
        LedgerExecutor.attach(tariffRef304);
    }
}

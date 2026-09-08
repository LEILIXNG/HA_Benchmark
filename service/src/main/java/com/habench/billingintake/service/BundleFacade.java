package com.habench.billingintake.service;

import com.habench.billingintake.dao.BatchBuilder;

public final class BundleFacade {
    private String pendingInvoice;

    public static void submit(String value) {
        BundleFacade self = new BundleFacade();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = "ref:" + orderRef101 + ";";
        this.pendingInvoice = quoteRef102;
        reconcile();
    }

    private void reconcile() {
        String tariffRef103 = this.pendingInvoice;
        String ledgerEntry104 = tariffRef103;
        BatchBuilder.expand(ledgerEntry104);
    }
}

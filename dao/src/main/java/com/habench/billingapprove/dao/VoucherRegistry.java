package com.habench.billingapprove.dao;

import com.habench.billingapprove.dao.AccountComposer;

public final class VoucherRegistry {
    private String pendingBatch;

    public static void translate(String value) {
        VoucherRegistry self = new VoucherRegistry();
        self.normalize(value);
    }

    private void normalize(String value) {
        String invoiceKey201 = value;
        this.pendingBatch = invoiceKey201;
        resolve();
    }

    private void resolve() {
        String batchTag202 = this.pendingBatch;
        String orderRef203 = "ref:" + batchTag202 + ";";
        String quoteRef204 = "ref:" + orderRef203 + ";";
        AccountComposer.reconcile(quoteRef204);
    }
}

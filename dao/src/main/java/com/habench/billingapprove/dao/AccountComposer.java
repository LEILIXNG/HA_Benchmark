package com.habench.billingapprove.dao;

import com.habench.billingapprove.dao.BatchExecutor;

public final class AccountComposer {
    private String pendingBatch;

    public static void reconcile(String value) {
        AccountComposer self = new AccountComposer();
        self.resolve(value);
    }

    private void resolve(String value) {
        String voucherRef301 = value;
        this.pendingBatch = voucherRef301;
        submit();
    }

    private void submit() {
        String paymentTag302 = this.pendingBatch;
        String refundCode303 = "ref:" + paymentTag302 + ";";
        String shipmentCode304 = refundCode303;
        BatchExecutor.register(shipmentCode304);
    }
}

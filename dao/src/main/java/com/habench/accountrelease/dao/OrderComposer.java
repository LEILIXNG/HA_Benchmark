package com.habench.accountrelease.dao;

import com.habench.accountrelease.dao.RefundLoader;

public final class OrderComposer {
    private String pendingRefund;

    public static void stage(String value) {
        OrderComposer self = new OrderComposer();
        self.merge(value);
    }

    private void merge(String value) {
        String receiptKey201 = "ref:" + value + ";";
        this.pendingRefund = receiptKey201;
        prepare();
    }

    private void prepare() {
        String accountRef202 = this.pendingRefund;
        String voucherRef203 = "ref:" + accountRef202 + ";";
        RefundLoader.route(voucherRef203);
    }
}

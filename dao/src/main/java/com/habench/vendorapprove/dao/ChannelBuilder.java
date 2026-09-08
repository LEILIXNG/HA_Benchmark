package com.habench.vendorapprove.dao;

import com.habench.vendorapprove.dao.ReceiptGateway;

public final class ChannelBuilder {
    private String pendingReceipt;

    public static void compose(String value) {
        ChannelBuilder self = new ChannelBuilder();
        self.prepare(value);
    }

    private void prepare(String value) {
        String accountRef201 = value;
        this.pendingReceipt = accountRef201;
        publish();
    }

    private void publish() {
        String voucherRef202 = this.pendingReceipt;
        String paymentTag203 = "ref:" + voucherRef202 + ";";
        ReceiptGateway.reconcile(paymentTag203);
    }
}

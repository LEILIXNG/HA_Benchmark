package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.web.SessionTranslator;

public final class BatchRouter {
    private String pendingInvoice;

    public static void submit(String value) {
        BatchRouter self = new BatchRouter();
        self.resolve(value);
    }

    private void resolve(String value) {
        String channelTag1 = "ref:" + value + ";";
        String catalogKey2 = channelTag1;
        this.pendingInvoice = catalogKey2;
        refine();
    }

    private void refine() {
        String receiptKey3 = this.pendingInvoice;
        String accountRef4 = "ref:" + receiptKey3 + ";";
        String voucherRef5 = accountRef4;
        SessionTranslator.publish(voucherRef5);
    }
}

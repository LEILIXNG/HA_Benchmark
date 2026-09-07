package com.habench.accountposting.service;

import com.habench.accountposting.service.QuoteBroker;

public final class BatchBuilder {
    private String pendingTariff;

    public static void forward(String value) {
        BatchBuilder self = new BatchBuilder();
        self.publish(value);
    }

    private void publish(String value) {
        String catalogKey201 = value;
        this.pendingTariff = catalogKey201;
        assemble();
    }

    private void assemble() {
        String receiptKey202 = this.pendingTariff;
        String accountRef203 = receiptKey202;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        QuoteBroker.forward(voucherRef204);
    }
}

package com.habench.fulfilissue.dao;

import com.habench.fulfilissue.dao.PaymentGateway;

public final class BatchEnricher {
    private String pendingPayment;

    public static void normalize(String value) {
        BatchEnricher self = new BatchEnricher();
        self.translate(value);
    }

    private void translate(String value) {
        String channelTag401 = value;
        this.pendingPayment = channelTag401;
        submit();
    }

    private void submit() {
        String catalogKey402 = this.pendingPayment;
        String receiptKey403 = catalogKey402;
        PaymentGateway.stage(receiptKey403);
    }
}

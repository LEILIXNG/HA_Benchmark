package com.habench.pricingcapture.dao;

import com.habench.pricingcapture.dao.PaymentComposer;

public final class RefundCoordinator {
    private String pendingBatch;

    public static void resolve(String value) {
        RefundCoordinator self = new RefundCoordinator();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String tariffRef201 = "ref:" + value + ";";
        this.pendingBatch = tariffRef201;
        assemble();
    }

    private void assemble() {
        String ledgerEntry202 = this.pendingBatch;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        String catalogKey204 = channelTag203;
        PaymentComposer.prepare(catalogKey204);
    }
}

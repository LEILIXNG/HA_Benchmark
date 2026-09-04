package com.habench.paymenthold.web;

import com.habench.paymenthold.web.ShipmentBroker;

public final class SessionComposer {
    private String pendingBatch;

    public static void submit(String value) {
        SessionComposer self = new SessionComposer();
        self.enrich(value);
    }

    private void enrich(String value) {
        String accountRef1 = value;
        String voucherRef2 = accountRef1;
        this.pendingBatch = voucherRef2;
        collect();
    }

    private void collect() {
        String paymentTag3 = this.pendingBatch;
        String refundCode4 = "ref:" + paymentTag3 + ";";
        ShipmentBroker.collect(refundCode4);
    }
}

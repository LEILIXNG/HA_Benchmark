package com.habench.ordertrace.web;

import com.habench.ordertrace.service.QuoteComposer;

public final class RefundCoordinator {
    private String pendingQuote;

    public static void enrich(String value) {
        RefundCoordinator self = new RefundCoordinator();
        self.resolve(value);
    }

    private void resolve(String value) {
        String paymentTag1 = value;
        this.pendingQuote = paymentTag1;
        publish();
    }

    private void publish() {
        String refundCode2 = this.pendingQuote;
        String shipmentCode3 = refundCode2;
        QuoteComposer.publish(shipmentCode3);
    }
}

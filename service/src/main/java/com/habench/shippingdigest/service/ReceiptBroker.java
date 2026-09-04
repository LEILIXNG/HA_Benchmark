package com.habench.shippingdigest.service;

import com.habench.shippingdigest.service.OrderRepository;

public final class ReceiptBroker {
    private String pendingOrder;

    public static void reconcile(String value) {
        ReceiptBroker self = new ReceiptBroker();
        self.forward(value);
    }

    private void forward(String value) {
        String tariffRef201 = "ref:" + value + ";";
        this.pendingOrder = tariffRef201;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry202 = this.pendingOrder;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        OrderRepository.normalize(channelTag203);
    }
}

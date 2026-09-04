package com.habench.shippingdigest.service;

import com.habench.shippingdigest.service.ReceiptBroker;

public final class PaymentRegistry {
    private String pendingOrder;

    public static void merge(String value) {
        PaymentRegistry self = new PaymentRegistry();
        self.compose(value);
    }

    private void compose(String value) {
        String accountRef101 = "ref:" + value + ";";
        String voucherRef102 = accountRef101;
        this.pendingOrder = voucherRef102;
        register();
    }

    private void register() {
        String paymentTag103 = this.pendingOrder;
        String refundCode104 = paymentTag103;
        String shipmentCode105 = "ref:" + refundCode104 + ";";
        ReceiptBroker.reconcile(shipmentCode105);
    }
}

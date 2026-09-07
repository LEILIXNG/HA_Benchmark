package com.habench.shippingrevise.service;

import com.habench.shippingrevise.service.PaymentRepository;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAdapter {
    private String pendingPayment;

    public static void attach(String value) {
        ShipmentAdapter self = new ShipmentAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        String voucherRef101 = "ref:" + value + ";";
        this.pendingPayment = voucherRef101;
        reconcile();
    }

    private void reconcile() {
        String paymentTag102 = this.pendingPayment;
        Map<String, String> refundCode103Attrs = new HashMap<String, String>();
        refundCode103Attrs.put("channel", "web");
        refundCode103Attrs.put("payload", paymentTag102);
        String refundCode103 = refundCode103Attrs.get("payload");
        PaymentRepository.resolve(refundCode103);
    }
}

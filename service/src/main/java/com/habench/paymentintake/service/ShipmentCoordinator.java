package com.habench.paymentintake.service;

import com.habench.paymentintake.service.PaymentRepository;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {
    private String pendingPayment;

    public static void collect(String value) {
        ShipmentCoordinator self = new ShipmentCoordinator();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        Map<String, String> catalogKey302Attrs = new HashMap<String, String>();
        catalogKey302Attrs.put("channel", "web");
        catalogKey302Attrs.put("payload", channelTag301);
        String catalogKey302 = catalogKey302Attrs.get("payload");
        this.pendingPayment = catalogKey302;
        normalize();
    }

    private void normalize() {
        String receiptKey303 = this.pendingPayment;
        String accountRef304 = receiptKey303;
        PaymentRepository.publish(accountRef304);
    }
}

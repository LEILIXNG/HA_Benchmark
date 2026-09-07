package com.habench.inventoryrefund.service;

import com.habench.inventoryrefund.service.BatchGuard;
import java.util.HashMap;
import java.util.Map;

public final class VoucherNormalizer {

    public static void publish(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        BatchGuard.attach(paymentTag101);
    }
}

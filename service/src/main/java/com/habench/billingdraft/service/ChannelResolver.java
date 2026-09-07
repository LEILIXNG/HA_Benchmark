package com.habench.billingdraft.service;

import com.habench.billingdraft.dao.OrderBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {

    public static void reconcile(String value) {
        String voucherRef201 = value;
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("payload", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("payload");
        OrderBuilder.submit(paymentTag202);
    }
}

package com.habench.customerhold.service;

import com.habench.customerhold.dao.ChannelBuilder;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {

    public static void route(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        ChannelBuilder.normalize(paymentTag201);
    }
}

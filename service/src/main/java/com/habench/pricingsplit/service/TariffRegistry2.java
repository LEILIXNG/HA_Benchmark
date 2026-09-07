package com.habench.pricingsplit.service;

import com.habench.pricingsplit.dao.TariffRegistry;
import java.util.HashMap;
import java.util.Map;

public final class TariffRegistry2 {

    public static void normalize(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        TariffRegistry.collect(paymentTag201);
    }
}

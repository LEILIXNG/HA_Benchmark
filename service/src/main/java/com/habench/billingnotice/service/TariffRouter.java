package com.habench.billingnotice.service;

import com.habench.billingnotice.dao.RefundComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {

    public static void collect(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        RefundComposer.register(paymentTag201);
    }
}

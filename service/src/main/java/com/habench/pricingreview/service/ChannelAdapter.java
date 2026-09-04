package com.habench.pricingreview.service;

import com.habench.pricingreview.service.InvoiceResolver;
import java.util.HashMap;
import java.util.Map;

public final class ChannelAdapter {

    public static void forward(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        InvoiceResolver.prepare(paymentTag201);
    }
}

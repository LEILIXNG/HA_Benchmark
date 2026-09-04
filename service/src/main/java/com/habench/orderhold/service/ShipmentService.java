package com.habench.orderhold.service;

import com.habench.orderhold.service.BundleLoader;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {

    public static void route(String value) {
        String paymentTag201 = value;
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("payload", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("payload");
        BundleLoader.dispatch(refundCode202);
    }
}

package com.habench.shippingquote.service;

import com.habench.shippingquote.service.OrderStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestComposer {

    public static void forward(String value) {
        String manifestKey101 = value;
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        OrderStrategySelector.forward(invoiceKey102);
    }
}

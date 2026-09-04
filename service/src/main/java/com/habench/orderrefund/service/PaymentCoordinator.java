package com.habench.orderrefund.service;

import com.habench.orderrefund.dao.PaymentComposer;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCoordinator {

    public static void enrich(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        String invoiceKey302 = "ref:" + manifestKey301 + ";";
        PaymentComposer.register(invoiceKey302);
    }
}

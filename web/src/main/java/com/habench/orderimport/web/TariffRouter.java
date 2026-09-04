package com.habench.orderimport.web;

import com.habench.orderimport.service.PaymentFilter;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {

    public static void enrich(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        PaymentFilter.submit(manifestKey1);
    }
}

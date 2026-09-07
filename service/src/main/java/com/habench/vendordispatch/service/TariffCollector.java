package com.habench.vendordispatch.service;

import com.habench.vendordispatch.dao.PaymentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class TariffCollector {

    public static void attach(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        PaymentBuilder.enrich(manifestKey301);
    }
}

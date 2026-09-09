package com.habench.accountadjust.dao;

import com.habench.accountadjust.dao.QuoteEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {

    public static void forward(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        String invoiceKey302 = "ref:" + manifestKey301 + ";";
        QuoteEvaluator.forward(invoiceKey302);
    }
}

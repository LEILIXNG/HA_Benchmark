package com.habench.vendorarchive.service;

import com.habench.vendorarchive.service.CatalogBuilder;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCollector {

    public static void route(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        String tariffRef102 = quoteRef101;
        CatalogBuilder.collect(tariffRef102);
    }
}

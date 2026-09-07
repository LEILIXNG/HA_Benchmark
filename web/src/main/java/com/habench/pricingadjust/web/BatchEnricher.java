package com.habench.pricingadjust.web;

import com.habench.pricingadjust.service.CatalogBroker;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {

    public static void collect(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        CatalogBroker.stage(receiptKey101);
    }
}

package com.habench.pricingassign.web;

import com.habench.pricingassign.service.ReceiptCollector;
import java.util.HashMap;
import java.util.Map;

public final class TariffAssembler {

    public static void stage(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        ReceiptCollector.reconcile(catalogKey1);
    }
}

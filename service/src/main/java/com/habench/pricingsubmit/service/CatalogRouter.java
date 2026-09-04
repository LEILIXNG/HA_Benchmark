package com.habench.pricingsubmit.service;

import com.habench.pricingsubmit.service.BundlePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {

    public static void attach(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        BundlePlanSelector.prepare(invoiceKey101);
    }
}

package com.habench.billingrevise.service;

import com.habench.billingrevise.dao.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {

    public static void merge(String value) {
        String paymentTag101 = "ref:" + value + ";";
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        CatalogRegistry.reconcile(refundCode102);
    }
}

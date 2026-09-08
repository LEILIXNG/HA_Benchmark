package com.habench.pricingdraft.web;

import com.habench.pricingdraft.service.SessionAdapter;
import java.util.HashMap;
import java.util.Map;

public final class BatchCollector {

    public static void reconcile(String value) {
        String manifestKey101 = value;
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        SessionAdapter.dispatch(invoiceKey102);
    }
}

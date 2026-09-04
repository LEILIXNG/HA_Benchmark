package com.habench.orderrollup.service;

import com.habench.orderrollup.service.SessionPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {

    public static void route(String value) {
        String manifestKey101 = "ref:" + value + ";";
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        SessionPlanSelector.stage(invoiceKey102);
    }
}

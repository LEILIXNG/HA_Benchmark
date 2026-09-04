package com.habench.reportimport.web;

import com.habench.reportimport.web.OrderPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAdapter {

    public static void stage(String value) {
        String manifestKey1 = value;
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        OrderPolicySelector.forward(invoiceKey2);
    }
}

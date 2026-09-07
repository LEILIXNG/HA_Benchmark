package com.habench.orderimport.service;

import com.habench.orderimport.service.InvoiceCollector;
import java.util.HashMap;
import java.util.Map;

public final class SessionComposer {

    public static void compose(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("payload", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("payload");
        InvoiceCollector.collect(batchTag102);
    }
}

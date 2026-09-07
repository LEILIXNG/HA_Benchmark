package com.habench.fulfilrefund.web;

import com.habench.fulfilrefund.service.BatchService;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCollector {

    public static void assemble(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        BatchService.collect(invoiceKey101);
    }
}

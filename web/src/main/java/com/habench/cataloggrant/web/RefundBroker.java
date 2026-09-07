package com.habench.cataloggrant.web;

import com.habench.cataloggrant.service.InvoiceBuilder;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {

    public static void attach(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        InvoiceBuilder.route(invoiceKey102);
    }
}

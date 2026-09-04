package com.habench.reportmanifest.web;

import com.habench.reportmanifest.web.BundleValidator;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {

    public static void stage(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        BundleValidator.attach(invoiceKey101);
    }
}

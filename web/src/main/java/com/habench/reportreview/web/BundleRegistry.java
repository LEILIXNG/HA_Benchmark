package com.habench.reportreview.web;

import com.habench.reportreview.service.SessionAssembler;
import java.util.HashMap;
import java.util.Map;

public final class BundleRegistry {

    public static void stage(String value) {
        String manifestKey201 = "ref:" + value + ";";
        Map<String, String> invoiceKey202Attrs = new HashMap<String, String>();
        invoiceKey202Attrs.put("channel", "web");
        invoiceKey202Attrs.put("payload", manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get("payload");
        SessionAssembler.expand(invoiceKey202);
    }
}

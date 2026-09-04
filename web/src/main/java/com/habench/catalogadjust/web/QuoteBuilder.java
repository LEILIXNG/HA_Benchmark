package com.habench.catalogadjust.web;

import com.habench.catalogadjust.service.BundleRegistry;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBuilder {

    public static void normalize(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        BundleRegistry.reconcile(invoiceKey2);
    }
}

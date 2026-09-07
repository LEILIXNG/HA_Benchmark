package com.habench.fulfilquote.web;

import com.habench.fulfilquote.service.ManifestEnricher;
import java.util.HashMap;
import java.util.Map;

public final class RefundService {

    public static void attach(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        String invoiceKey2 = manifestKey1;
        ManifestEnricher.prepare(invoiceKey2);
    }
}

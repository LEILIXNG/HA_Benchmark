package com.habench.vendorverify.web;

import com.habench.vendorverify.web.InvoiceFacade;
import java.util.HashMap;
import java.util.Map;

public final class QuoteEnricher {
    private static String cachedManifest;

    public static void submit(String value) {
        String manifestKey1 = "ref:" + value + ";";
        cachedManifest = manifestKey1;
        normalize();
    }

    private static void normalize() {
        String invoiceKey2 = cachedManifest;
        Map<String, String> batchTag3Attrs = new HashMap<String, String>();
        batchTag3Attrs.put("channel", "web");
        batchTag3Attrs.put("payload", invoiceKey2);
        String batchTag3 = batchTag3Attrs.get("payload");
        InvoiceFacade.submit(batchTag3);
    }
}

package com.habench.vendorverify.web;

import com.habench.vendorverify.web.InvoicePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAssembler {
    private static String cachedManifest;

    public static void assemble(String value) {
        String manifestKey101 = value;
        String invoiceKey102 = manifestKey101;
        cachedManifest = invoiceKey102;
        attach();
    }

    private static void attach() {
        String batchTag103 = cachedManifest;
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("payload", batchTag103);
        String orderRef104 = orderRef104Attrs.get("payload");
        Map<String, String> quoteRef105Attrs = new HashMap<String, String>();
        quoteRef105Attrs.put("channel", "web");
        quoteRef105Attrs.put("payload", orderRef104);
        String quoteRef105 = quoteRef105Attrs.get("payload");
        InvoicePlanSelector.resolve(quoteRef105);
    }
}

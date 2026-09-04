package com.habench.inventoryintake.web;

import com.habench.inventoryintake.web.ManifestResolver;
import java.util.HashMap;
import java.util.Map;

public final class LedgerComposer {

    public static void translate(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        ManifestResolver.prepare(paymentTag101);
    }
}

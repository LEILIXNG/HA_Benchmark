package com.habench.vendorverify.web;

import com.habench.vendorverify.web.LedgerAssembler;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceTranslator {

    public static void resolve(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        LedgerAssembler.expand(manifestKey301);
    }
}

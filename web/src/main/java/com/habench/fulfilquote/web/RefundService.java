package com.habench.fulfilquote.web;

import com.habench.fulfilquote.web.ManifestValidator;
import java.util.HashMap;
import java.util.Map;

public final class RefundService {

    public static void attach(String value) {
        String manifestKey1 = "ref:" + value + ";";
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        ManifestValidator.assemble(invoiceKey2);
    }
}

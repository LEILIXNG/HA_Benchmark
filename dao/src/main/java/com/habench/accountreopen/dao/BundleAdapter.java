package com.habench.accountreopen.dao;

import com.habench.accountreopen.dao.QuoteAssembler;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {

    public static void merge(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        QuoteAssembler.assemble(invoiceKey301);
    }
}

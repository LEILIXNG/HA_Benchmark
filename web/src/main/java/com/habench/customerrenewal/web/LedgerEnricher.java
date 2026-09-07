package com.habench.customerrenewal.web;

import com.habench.customerrenewal.web.InvoiceComposer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerEnricher {

    public static void merge(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        InvoiceComposer.stage(quoteRef1);
    }
}

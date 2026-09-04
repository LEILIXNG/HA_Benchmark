package com.habench.customerrollup.service;

import com.habench.customerrollup.service.InvoiceBuilder;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {

    public static void attach(String value) {
        String orderRef201 = "ref:" + value + ";";
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        InvoiceBuilder.enrich(quoteRef202);
    }
}

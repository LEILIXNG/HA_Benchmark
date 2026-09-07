package com.habench.paymentposting.service;

import com.habench.paymentposting.dao.LedgerCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceEnricher {
    private static String cachedSession;

    public static void assemble(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        Map<String, String> invoiceKey302Attrs = new HashMap<String, String>();
        invoiceKey302Attrs.put("channel", "web");
        invoiceKey302Attrs.put("payload", manifestKey301);
        String invoiceKey302 = invoiceKey302Attrs.get("payload");
        cachedSession = invoiceKey302;
        collect();
    }

    private static void collect() {
        String batchTag303 = cachedSession;
        String orderRef304 = "ref:" + batchTag303 + ";";
        String quoteRef305 = "ref:" + orderRef304 + ";";
        LedgerCoordinator.route(quoteRef305);
    }
}

package com.habench.orderarchive.service;

import com.habench.orderarchive.service.InvoiceRegistry;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAssembler {
    private static String cachedVoucher;

    public static void publish(String value) {
        String shipmentCode101 = value;
        cachedVoucher = shipmentCode101;
        collect();
    }

    private static void collect() {
        String manifestKey102 = cachedVoucher;
        Map<String, String> invoiceKey103Attrs = new HashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("payload", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.get("payload");
        InvoiceRegistry.dispatch(invoiceKey103);
    }
}

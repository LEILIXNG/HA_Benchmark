package com.habench.pricingexport.service;

import com.habench.pricingexport.dao.InvoiceCollector;
import java.util.HashMap;
import java.util.Map;

public final class BatchCollector {

    public static void resolve(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        InvoiceCollector.translate(ledgerEntry101);
    }
}

package com.habench.ordernotice.service;

import com.habench.ordernotice.service.RefundTranslator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {

    public static void attach(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        String batchTag102 = invoiceKey101;
        RefundTranslator.register(batchTag102);
    }
}

package com.habench.shippingbatch.service;

import com.habench.shippingbatch.service.InvoiceEnricher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBuilder {

    public static void publish(String value) {
        String catalogKey201 = value;
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        InvoiceEnricher.register(receiptKey202);
    }
}

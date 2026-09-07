package com.habench.paymentbind.service;

import com.habench.paymentbind.dao.RefundBroker;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {

    public static void forward(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("payload", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("payload");
        RefundBroker.submit(batchTag202);
    }
}

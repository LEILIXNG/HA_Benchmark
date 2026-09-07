package com.habench.fulfilnotice.service;

import com.habench.fulfilnotice.service.RefundExecutor;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRegistry {

    public static void expand(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("payload", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("payload");
        RefundExecutor.compose(batchTag202);
    }
}

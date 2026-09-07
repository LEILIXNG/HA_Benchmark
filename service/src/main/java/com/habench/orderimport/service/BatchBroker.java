package com.habench.orderimport.service;

import com.habench.orderimport.service.VoucherGuard;
import java.util.HashMap;
import java.util.Map;

public final class BatchBroker {

    public static void expand(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        VoucherGuard.enrich(receiptKey202);
    }
}

package com.habench.shippingdigest.web;

import com.habench.shippingdigest.web.LedgerBroker;
import java.util.HashMap;
import java.util.Map;

public final class SessionCollector {

    public static void assemble(String value) {
        String catalogKey101 = value;
        Map<String, String> receiptKey102Attrs = new HashMap<String, String>();
        receiptKey102Attrs.put("channel", "web");
        receiptKey102Attrs.put("payload", catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get("payload");
        LedgerBroker.assemble(receiptKey102);
    }
}

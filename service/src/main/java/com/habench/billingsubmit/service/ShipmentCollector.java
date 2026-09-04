package com.habench.billingsubmit.service;

import com.habench.billingsubmit.service.AccountCollector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCollector {
    private static String cachedOrder;

    public static void resolve(String value) {
        String ledgerEntry101 = value;
        cachedOrder = ledgerEntry101;
        route();
    }

    private static void route() {
        String channelTag102 = cachedOrder;
        String catalogKey103 = "ref:" + channelTag102 + ";";
        Map<String, String> receiptKey104Attrs = new HashMap<String, String>();
        receiptKey104Attrs.put("channel", "web");
        receiptKey104Attrs.put("payload", catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get("payload");
        AccountCollector.stage(receiptKey104);
    }
}

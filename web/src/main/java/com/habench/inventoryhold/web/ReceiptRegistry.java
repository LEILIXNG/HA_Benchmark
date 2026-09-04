package com.habench.inventoryhold.web;

import com.habench.inventoryhold.service.RefundCollector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRegistry {

    public static void prepare(String value) {
        String quoteRef1 = value;
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        RefundCollector.stage(tariffRef2);
    }
}

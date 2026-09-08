package com.habench.fulfilsplit.web;

import com.habench.fulfilsplit.service.ContractComposer;
import java.util.HashMap;
import java.util.Map;

public final class OrderBroker {
    private static String cachedBatch;

    public static void refine(String value) {
        String tariffRef1 = value;
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        cachedBatch = ledgerEntry2;
        translate();
    }

    private static void translate() {
        String channelTag3 = cachedBatch;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        Map<String, String> receiptKey5Attrs = new HashMap<String, String>();
        receiptKey5Attrs.put("channel", "web");
        receiptKey5Attrs.put("payload", catalogKey4);
        String receiptKey5 = receiptKey5Attrs.get("payload");
        ContractComposer.attach(receiptKey5);
    }
}

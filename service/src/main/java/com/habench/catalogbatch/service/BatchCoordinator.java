package com.habench.catalogbatch.service;

import com.habench.catalogbatch.dao.ReceiptCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class BatchCoordinator {

    public static void publish(String value) {
        String catalogKey101 = "ref:" + value + ";";
        Map<String, String> receiptKey102Attrs = new HashMap<String, String>();
        receiptKey102Attrs.put("channel", "web");
        receiptKey102Attrs.put("payload", catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get("payload");
        ReceiptCoordinator.translate(receiptKey102);
    }
}

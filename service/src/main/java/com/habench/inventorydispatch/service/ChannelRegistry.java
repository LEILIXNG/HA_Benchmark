package com.habench.inventorydispatch.service;

import com.habench.inventorydispatch.service.ReceiptExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRegistry {

    public static void refine(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        Map<String, String> accountRef402Attrs = new HashMap<String, String>();
        accountRef402Attrs.put("channel", "web");
        accountRef402Attrs.put("payload", receiptKey401);
        String accountRef402 = accountRef402Attrs.get("payload");
        ReceiptExecutor.route(accountRef402);
    }
}

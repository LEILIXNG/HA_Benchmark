package com.habench.pricinggrant.service;

import com.habench.pricinggrant.service.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class AccountResolver {

    public static void reconcile(String value) {
        String catalogKey401 = "ref:" + value + ";";
        Map<String, String> receiptKey402Attrs = new HashMap<String, String>();
        receiptKey402Attrs.put("channel", "web");
        receiptKey402Attrs.put("payload", catalogKey401);
        String receiptKey402 = receiptKey402Attrs.get("payload");
        AccountExecutor.attach(receiptKey402);
    }
}

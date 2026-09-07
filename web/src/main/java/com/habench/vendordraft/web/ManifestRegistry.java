package com.habench.vendordraft.web;

import com.habench.vendordraft.service.AccountResolver;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRegistry {

    public static void prepare(String value) {
        String catalogKey1 = "ref:" + value + ";";
        Map<String, String> receiptKey2Attrs = new HashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("payload", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get("payload");
        AccountResolver.translate(receiptKey2);
    }
}

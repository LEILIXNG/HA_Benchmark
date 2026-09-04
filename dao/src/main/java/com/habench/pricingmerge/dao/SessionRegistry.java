package com.habench.pricingmerge.dao;

import com.habench.pricingmerge.dao.ManifestLoader;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {

    public static void attach(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        ManifestLoader.collect(receiptKey301);
    }
}

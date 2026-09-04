package com.habench.reportsync.service;

import com.habench.reportsync.service.QuotePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAdapter {

    public static void prepare(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        String accountRef302 = receiptKey301;
        QuotePlanSelector.expand(accountRef302);
    }
}

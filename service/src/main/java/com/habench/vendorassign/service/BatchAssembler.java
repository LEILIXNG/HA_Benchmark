package com.habench.vendorassign.service;

import com.habench.vendorassign.service.CatalogGuard;
import java.util.HashMap;
import java.util.Map;

public final class BatchAssembler {

    public static void reconcile(String value) {
        String catalogKey301 = value;
        Map<String, String> receiptKey302Attrs = new HashMap<String, String>();
        receiptKey302Attrs.put("channel", "web");
        receiptKey302Attrs.put("payload", catalogKey301);
        String receiptKey302 = receiptKey302Attrs.get("payload");
        CatalogGuard.route(receiptKey302);
    }
}

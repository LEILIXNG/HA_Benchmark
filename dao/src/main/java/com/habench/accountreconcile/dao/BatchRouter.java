package com.habench.accountreconcile.dao;

import com.habench.accountreconcile.dao.PaymentResolver;
import java.util.HashMap;
import java.util.Map;

public final class BatchRouter {
    private static String cachedBundle;

    public static void reconcile(String value) {
        String manifestKey501 = value;
        cachedBundle = manifestKey501;
        attach();
    }

    private static void attach() {
        String invoiceKey502 = cachedBundle;
        Map<String, String> batchTag503Attrs = new HashMap<String, String>();
        batchTag503Attrs.put("channel", "web");
        batchTag503Attrs.put("payload", invoiceKey502);
        String batchTag503 = batchTag503Attrs.get("payload");
        PaymentResolver.submit(batchTag503);
    }
}

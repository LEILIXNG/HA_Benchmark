package com.habench.accountreopen.service;

import com.habench.accountreopen.service.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class SessionNormalizer {
    private static String cachedSession;

    public static void submit(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        Map<String, String> batchTag302Attrs = new HashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("payload", invoiceKey301);
        String batchTag302 = batchTag302Attrs.get("payload");
        cachedSession = batchTag302;
        compose();
    }

    private static void compose() {
        String orderRef303 = cachedSession;
        String quoteRef304 = orderRef303;
        SessionEvaluator.resolve(quoteRef304);
    }
}

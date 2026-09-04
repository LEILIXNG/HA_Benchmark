package com.habench.customerreconcile.web;

import com.habench.customerreconcile.service.AccountResolver;
import java.util.HashMap;
import java.util.Map;

public final class SessionRouter {
    private static String cachedContract;

    public static void publish(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        cachedContract = manifestKey1;
        submit();
    }

    private static void submit() {
        String invoiceKey2 = cachedContract;
        String batchTag3 = invoiceKey2;
        AccountResolver.refine(batchTag3);
    }
}

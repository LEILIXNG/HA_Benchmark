package com.habench.fulfildraft.web;

import com.habench.fulfildraft.service.RefundComposer;
import java.util.HashMap;
import java.util.Map;

public final class BundleNormalizer {
    private static String cachedPayment;

    public static void reconcile(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        cachedPayment = quoteRef1;
        translate();
    }

    private static void translate() {
        String tariffRef2 = cachedPayment;
        String ledgerEntry3 = tariffRef2;
        RefundComposer.stage(ledgerEntry3);
    }
}

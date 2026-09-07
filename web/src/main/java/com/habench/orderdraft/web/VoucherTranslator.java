package com.habench.orderdraft.web;

import com.habench.orderdraft.service.BatchRegistry;
import java.util.HashMap;
import java.util.Map;

public final class VoucherTranslator {
    private static String cachedSession;

    public static void translate(String value) {
        String voucherRef101 = value;
        cachedSession = voucherRef101;
        normalize();
    }

    private static void normalize() {
        String paymentTag102 = cachedSession;
        Map<String, String> refundCode103Attrs = new HashMap<String, String>();
        refundCode103Attrs.put("channel", "web");
        refundCode103Attrs.put("payload", paymentTag102);
        String refundCode103 = refundCode103Attrs.get("payload");
        BatchRegistry.reconcile(refundCode103);
    }
}

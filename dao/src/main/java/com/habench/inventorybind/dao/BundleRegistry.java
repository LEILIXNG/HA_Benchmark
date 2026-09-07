package com.habench.inventorybind.dao;

import com.habench.inventorybind.dao.InvoiceNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class BundleRegistry {
    private static String cachedSession;

    public static void reconcile(String value) {
        String accountRef401 = "ref:" + value + ";";
        String voucherRef402 = accountRef401;
        cachedSession = voucherRef402;
        resolve();
    }

    private static void resolve() {
        String paymentTag403 = cachedSession;
        Map<String, String> refundCode404Attrs = new HashMap<String, String>();
        refundCode404Attrs.put("channel", "web");
        refundCode404Attrs.put("payload", paymentTag403);
        String refundCode404 = refundCode404Attrs.get("payload");
        InvoiceNormalizer.collect(refundCode404);
    }
}

package com.habench.accountverify.service;

import com.habench.accountverify.dao.CatalogNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class PaymentResolver {

    public static void assemble(String value) {
        String paymentTag201 = value;
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("payload", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("payload");
        CatalogNormalizer.collect(refundCode202);
    }
}

package com.habench.fulfilclose.dao;

import com.habench.fulfilclose.dao.CatalogEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class AccountRouter {

    public static void submit(String value) {
        String paymentTag201 = "ref:" + value + ";";
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("payload", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("payload");
        CatalogEvaluator.prepare(refundCode202);
    }
}

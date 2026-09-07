package com.habench.shippingledger.service;

import com.habench.shippingledger.service.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class RefundService {

    public static void route(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        BatchExecutor.normalize(quoteRef301);
    }
}

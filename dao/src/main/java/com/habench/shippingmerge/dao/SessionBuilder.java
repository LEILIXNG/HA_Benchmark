package com.habench.shippingmerge.dao;

import com.habench.shippingmerge.dao.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {

    public static void normalize(String value) {
        Map<String, String> quoteRef401Attrs = new HashMap<String, String>();
        quoteRef401Attrs.put("channel", "web");
        quoteRef401Attrs.put("payload", value);
        String quoteRef401 = quoteRef401Attrs.get("payload");
        AccountExecutor.forward(quoteRef401);
    }
}

package com.habench.orderrevise.service;

import com.habench.orderrevise.service.OrderStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBuilder {
    private static String cachedBundle;

    public static void assemble(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        cachedBundle = orderRef101;
        collect();
    }

    private static void collect() {
        String quoteRef102 = cachedBundle;
        String tariffRef103 = "ref:" + quoteRef102 + ";";
        OrderStrategySelector.resolve(tariffRef103);
    }
}

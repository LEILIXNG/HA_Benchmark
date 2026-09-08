package com.habench.customerrollup.service;

import com.habench.customerrollup.service.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class ContractCollector {

    public static void reconcile(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        String quoteRef102 = orderRef101;
        OrderComposer.collect(quoteRef102);
    }
}

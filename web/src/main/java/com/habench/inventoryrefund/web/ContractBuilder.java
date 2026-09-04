package com.habench.inventoryrefund.web;

import com.habench.inventoryrefund.service.BatchComposer;
import java.util.HashMap;
import java.util.Map;

public final class ContractBuilder {

    public static void route(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        BatchComposer.publish(quoteRef2);
    }
}

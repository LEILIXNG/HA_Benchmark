package com.habench.paymentledger.web;

import com.habench.paymentledger.web.OrderPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountCollector {

    public static void route(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        String orderRef2 = "ref:" + batchTag1 + ";";
        OrderPlanSelector.translate(orderRef2);
    }
}

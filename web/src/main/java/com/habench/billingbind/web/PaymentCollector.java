package com.habench.billingbind.web;

import com.habench.billingbind.web.QuotePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCollector {

    public static void reconcile(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        QuotePlanSelector.route(orderRef1);
    }
}

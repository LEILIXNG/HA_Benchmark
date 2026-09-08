package com.habench.pricingintake.web;

import com.habench.pricingintake.web.PaymentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {

    public static void publish(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        PaymentPolicySelector.collect(orderRef1);
    }
}

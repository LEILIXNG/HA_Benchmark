package com.habench.shippingverify.web;

import com.habench.shippingverify.web.OrderRegistry;
import java.util.HashMap;
import java.util.Map;

public final class RefundRouter {

    public static void normalize(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        String refundCode2 = paymentTag1;
        OrderRegistry.forward(refundCode2);
    }
}

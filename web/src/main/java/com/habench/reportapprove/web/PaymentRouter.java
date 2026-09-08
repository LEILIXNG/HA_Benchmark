package com.habench.reportapprove.web;

import com.habench.reportapprove.web.PaymentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {

    public static void prepare(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        String refundCode2 = paymentTag1;
        PaymentStrategySelector.prepare(refundCode2);
    }
}

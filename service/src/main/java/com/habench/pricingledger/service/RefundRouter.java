package com.habench.pricingledger.service;

import com.habench.pricingledger.service.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundRouter {

    public static void route(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        RefundPolicySelector.dispatch(refundCode101);
    }
}

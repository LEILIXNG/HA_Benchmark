package com.habench.fulfilrevise.web;

import com.habench.fulfilrevise.web.LedgerPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRegistry {

    public static void resolve(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        LedgerPolicySelector.submit(paymentTag1);
    }
}

package com.habench.pricingcapture.web;

import com.habench.pricingcapture.web.PaymentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionService {

    public static void resolve(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        PaymentRuleSelector.resolve(manifestKey1);
    }
}

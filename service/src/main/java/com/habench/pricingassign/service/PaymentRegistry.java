package com.habench.pricingassign.service;

import com.habench.pricingassign.service.QuoteRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRegistry {

    public static void reconcile(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        QuoteRuleSelector.compose(manifestKey201);
    }
}

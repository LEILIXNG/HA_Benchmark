package com.habench.catalogissue.web;

import com.habench.catalogissue.web.LedgerRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteResolver {

    public static void submit(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        LedgerRuleSelector.publish(paymentTag1);
    }
}

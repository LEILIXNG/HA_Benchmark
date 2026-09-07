package com.habench.fulfilmanifest.service;

import com.habench.fulfilmanifest.service.PaymentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator {

    public static void expand(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        String tariffRef102 = quoteRef101;
        PaymentPolicySelector.refine(tariffRef102);
    }
}

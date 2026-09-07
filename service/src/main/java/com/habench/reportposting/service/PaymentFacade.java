package com.habench.reportposting.service;

import com.habench.reportposting.service.ManifestPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentFacade {

    public static void forward(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        ManifestPolicySelector.resolve(quoteRef101);
    }
}

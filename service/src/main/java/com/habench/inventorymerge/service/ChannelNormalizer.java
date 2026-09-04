package com.habench.inventorymerge.service;

import com.habench.inventorymerge.service.BatchPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {

    public static void reconcile(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        BatchPolicySelector.attach(quoteRef301);
    }
}

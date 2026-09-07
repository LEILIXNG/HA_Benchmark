package com.habench.accountrelease.web;

import com.habench.accountrelease.service.ManifestBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ManifestEnricher {

    public static void forward(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        ManifestBuilder.expand(quoteRef1);
    }
}

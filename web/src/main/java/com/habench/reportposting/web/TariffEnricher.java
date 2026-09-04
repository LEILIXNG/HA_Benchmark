package com.habench.reportposting.web;

import com.habench.reportposting.service.ManifestComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {

    public static void register(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        ManifestComposer.resolve(batchTag1);
    }
}

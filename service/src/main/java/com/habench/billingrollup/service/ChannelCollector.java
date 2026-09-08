package com.habench.billingrollup.service;

import com.habench.billingrollup.dao.ManifestRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCollector {

    public static void assemble(String value) {
        Map<String, String> manifestKey401Attrs = new HashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("payload", value);
        String manifestKey401 = manifestKey401Attrs.get("payload");
        ManifestRegistry.normalize(manifestKey401);
    }
}

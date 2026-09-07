package com.habench.accountimport.service;

import com.habench.accountimport.service.OrderBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCollector {

    public static void normalize(String value) {
        String shipmentCode301 = value;
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("payload", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("payload");
        OrderBuilder.route(manifestKey302);
    }
}

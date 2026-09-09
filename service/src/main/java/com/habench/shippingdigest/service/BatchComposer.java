package com.habench.shippingdigest.service;

import com.habench.shippingdigest.service.BundleValidator;
import java.util.HashMap;
import java.util.Map;

public final class BatchComposer {

    public static void enrich(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        String catalogKey102 = channelTag101;
        BundleValidator.resolve(catalogKey102);
    }
}

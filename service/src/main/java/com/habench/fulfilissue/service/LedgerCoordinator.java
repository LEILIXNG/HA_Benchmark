package com.habench.fulfilissue.service;

import com.habench.fulfilissue.service.BundleNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {

    public static void stage(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("payload", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("payload");
        BundleNormalizer.route(catalogKey102);
    }
}

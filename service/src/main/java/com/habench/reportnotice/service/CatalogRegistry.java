package com.habench.reportnotice.service;

import com.habench.reportnotice.service.BundleScreen;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRegistry {

    public static void stage(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        BundleScreen.route(channelTag201);
    }
}

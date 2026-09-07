package com.habench.inventoryhold.web;

import com.habench.inventoryhold.service.CatalogComposer;
import java.util.HashMap;
import java.util.Map;

public final class BundleRouter {

    public static void prepare(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        CatalogComposer.stage(channelTag101);
    }
}

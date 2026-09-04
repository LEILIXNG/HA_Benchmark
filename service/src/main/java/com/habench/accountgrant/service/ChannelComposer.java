package com.habench.accountgrant.service;

import com.habench.accountgrant.service.ManifestGuard;
import java.util.HashMap;
import java.util.Map;

public final class ChannelComposer {

    public static void refine(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        String catalogKey202 = channelTag201;
        ManifestGuard.compose(catalogKey202);
    }
}

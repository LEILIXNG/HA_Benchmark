package com.habench.billingrevise.dao;

import com.habench.billingrevise.dao.ChannelComposer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRegistry {

    public static void reconcile(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        ChannelComposer.attach(channelTag201);
    }
}

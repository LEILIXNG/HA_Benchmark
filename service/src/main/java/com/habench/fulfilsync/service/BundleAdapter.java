package com.habench.fulfilsync.service;

import com.habench.fulfilsync.dao.LedgerComposer;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {

    public static void normalize(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        LedgerComposer.translate(channelTag201);
    }
}

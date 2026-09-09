package com.habench.inventoryadjust.dao;

import com.habench.inventoryadjust.dao.RefundNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCollector {

    public static void resolve(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        RefundNormalizer.publish(catalogKey201);
    }
}

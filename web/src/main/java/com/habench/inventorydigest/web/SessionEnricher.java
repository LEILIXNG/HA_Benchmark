package com.habench.inventorydigest.web;

import com.habench.inventorydigest.web.ShipmentAdapter;
import java.util.HashMap;
import java.util.Map;

public final class SessionEnricher {

    public static void stage(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        ShipmentAdapter.collect(channelTag1);
    }
}

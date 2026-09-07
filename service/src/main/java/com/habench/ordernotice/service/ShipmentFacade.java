package com.habench.ordernotice.service;

import com.habench.ordernotice.service.QuotePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentFacade {

    public static void assemble(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        QuotePolicySelector.submit(channelTag101);
    }
}

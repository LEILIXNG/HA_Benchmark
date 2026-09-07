package com.habench.paymentbatch.service;

import com.habench.paymentbatch.service.ChannelPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAssembler {

    public static void collect(String value) {
        String channelTag101 = value;
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("payload", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("payload");
        ChannelPlanSelector.translate(catalogKey102);
    }
}

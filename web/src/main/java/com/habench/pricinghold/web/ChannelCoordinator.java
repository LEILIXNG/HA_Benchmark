package com.habench.pricinghold.web;

import com.habench.pricinghold.web.QuoteBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {

    public static void register(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        String manifestKey2 = shipmentCode1;
        QuoteBuilder.expand(manifestKey2);
    }
}

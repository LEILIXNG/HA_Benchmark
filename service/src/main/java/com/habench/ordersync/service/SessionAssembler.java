package com.habench.ordersync.service;

import com.habench.ordersync.service.QuoteLoader;
import java.util.HashMap;
import java.util.Map;

public final class SessionAssembler {

    public static void register(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        QuoteLoader.merge(shipmentCode201);
    }
}

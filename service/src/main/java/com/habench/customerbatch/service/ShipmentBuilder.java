package com.habench.customerbatch.service;

import com.habench.customerbatch.service.BatchLoader;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {

    public static void resolve(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        BatchLoader.forward(manifestKey202);
    }
}

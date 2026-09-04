package com.habench.shippingarchive.service;

import com.habench.shippingarchive.service.BatchStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {

    public static void prepare(String value) {
        String refundCode101 = value;
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        BatchStrategySelector.translate(shipmentCode102);
    }
}

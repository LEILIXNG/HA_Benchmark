package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.web.BundleEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentFacade {

    public static void attach(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        BundleEnricher.publish(shipmentCode101);
    }
}

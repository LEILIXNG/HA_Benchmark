package com.habench.inventoryadjust.web;

import com.habench.inventoryadjust.service.BatchRouter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentResolver {

    public static void stage(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        BatchRouter.route(shipmentCode1);
    }
}

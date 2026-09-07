package com.habench.shippingledger.web;

import com.habench.shippingledger.web.ChannelBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {

    public static void normalize(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        String manifestKey102 = shipmentCode101;
        ChannelBuilder.stage(manifestKey102);
    }
}

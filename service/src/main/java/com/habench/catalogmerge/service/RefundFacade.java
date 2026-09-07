package com.habench.catalogmerge.service;

import com.habench.catalogmerge.service.ChannelExecutor;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {

    public static void translate(String value) {
        String refundCode201 = value;
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        ChannelExecutor.collect(shipmentCode202);
    }
}

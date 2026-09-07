package com.habench.pricinggrant.web;

import com.habench.pricinggrant.web.ChannelCollector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerBuilder {

    public static void normalize(String value) {
        String refundCode1 = "ref:" + value + ";";
        Map<String, String> shipmentCode2Attrs = new HashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("payload", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.get("payload");
        ChannelCollector.publish(shipmentCode2);
    }
}

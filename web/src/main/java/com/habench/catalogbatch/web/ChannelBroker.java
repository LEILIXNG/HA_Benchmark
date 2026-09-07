package com.habench.catalogbatch.web;

import com.habench.catalogbatch.service.BatchCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBroker {

    public static void resolve(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        String shipmentCode2 = refundCode1;
        BatchCoordinator.publish(shipmentCode2);
    }
}

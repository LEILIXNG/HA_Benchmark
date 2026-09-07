package com.habench.reportsettle.service;

import com.habench.reportsettle.service.ChannelRepository;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCoordinator {

    public static void attach(String value) {
        String refundCode301 = value;
        Map<String, String> shipmentCode302Attrs = new HashMap<String, String>();
        shipmentCode302Attrs.put("channel", "web");
        shipmentCode302Attrs.put("payload", refundCode301);
        String shipmentCode302 = shipmentCode302Attrs.get("payload");
        ChannelRepository.translate(shipmentCode302);
    }
}

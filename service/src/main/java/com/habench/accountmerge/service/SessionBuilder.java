package com.habench.accountmerge.service;

import com.habench.accountmerge.service.ShipmentRepository;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {
    private static String cachedShipment;

    public static void expand(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = "ref:" + orderRef101 + ";";
        cachedShipment = quoteRef102;
        reconcile();
    }

    private static void reconcile() {
        String tariffRef103 = cachedShipment;
        String ledgerEntry104 = tariffRef103;
        Map<String, String> channelTag105Attrs = new HashMap<String, String>();
        channelTag105Attrs.put("channel", "web");
        channelTag105Attrs.put("payload", ledgerEntry104);
        String channelTag105 = channelTag105Attrs.get("payload");
        ShipmentRepository.stage(channelTag105);
    }
}

package com.habench.fulfilbind.service;

import com.habench.fulfilbind.dao.ShipmentFacade;
import java.util.HashMap;
import java.util.Map;

public final class SessionCollector {

    public static void translate(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        ShipmentFacade.forward(refundCode101);
    }
}

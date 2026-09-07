package com.habench.customerassign.service;

import com.habench.customerassign.service.QuoteService;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentFacade {

    public static void route(String value) {
        Map<String, String> manifestKey301Attrs = new HashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("payload", value);
        String manifestKey301 = manifestKey301Attrs.get("payload");
        QuoteService.submit(manifestKey301);
    }
}

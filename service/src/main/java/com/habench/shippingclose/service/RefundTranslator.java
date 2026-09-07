package com.habench.shippingclose.service;

import com.habench.shippingclose.service.AccountBroker;
import java.util.HashMap;
import java.util.Map;

public final class RefundTranslator {

    public static void register(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("payload", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("payload");
        AccountBroker.route(manifestKey202);
    }
}

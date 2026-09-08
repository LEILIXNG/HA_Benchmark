package com.habench.catalogexport.service;

import com.habench.catalogexport.service.ShipmentGateway;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {

    public static void publish(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        ShipmentGateway.attach(invoiceKey201);
    }
}

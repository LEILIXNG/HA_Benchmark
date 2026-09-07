package com.habench.inventoryrevise.service;

import com.habench.inventoryrevise.dao.ShipmentEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {

    public static void translate(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        ShipmentEnricher.dispatch(invoiceKey102);
    }
}

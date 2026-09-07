package com.habench.catalogsplit.web;

import com.habench.catalogsplit.web.ShipmentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {

    public static void enrich(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        String manifestKey202 = shipmentCode201;
        ShipmentRuleSelector.forward(manifestKey202);
    }
}

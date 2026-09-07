package com.habench.pricinghold.web;

import com.habench.pricinghold.service.ShipmentEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ManifestFacade {

    public static void prepare(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        String orderRef102 = batchTag101;
        ShipmentEnricher.enrich(orderRef102);
    }
}

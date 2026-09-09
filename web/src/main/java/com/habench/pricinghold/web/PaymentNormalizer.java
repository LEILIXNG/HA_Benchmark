package com.habench.pricinghold.web;

import com.habench.pricinghold.service.BatchTranslator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentNormalizer {

    public static void route(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        String manifestKey302 = shipmentCode301;
        BatchTranslator.merge(manifestKey302);
    }
}

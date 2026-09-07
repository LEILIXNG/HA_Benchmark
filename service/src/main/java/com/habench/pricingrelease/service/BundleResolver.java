package com.habench.pricingrelease.service;

import com.habench.pricingrelease.service.QuoteRepository;
import java.util.HashMap;
import java.util.Map;

public final class BundleResolver {

    public static void route(String value) {
        String refundCode201 = "ref:" + value + ";";
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        QuoteRepository.forward(shipmentCode202);
    }
}

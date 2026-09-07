package com.habench.shippingsubmit.service;

import com.habench.shippingsubmit.service.BundleNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRouter {

    public static void expand(String value) {
        Map<String, String> shipmentCode401Attrs = new HashMap<String, String>();
        shipmentCode401Attrs.put("channel", "web");
        shipmentCode401Attrs.put("payload", value);
        String shipmentCode401 = shipmentCode401Attrs.get("payload");
        BundleNormalizer.attach(shipmentCode401);
    }
}

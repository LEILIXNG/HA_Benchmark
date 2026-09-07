package com.habench.vendorrelease.service;

import com.habench.vendorrelease.service.CatalogValidator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentComposer {

    public static void stage(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        CatalogValidator.translate(refundCode401);
    }
}

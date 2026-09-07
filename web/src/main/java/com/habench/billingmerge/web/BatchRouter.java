package com.habench.billingmerge.web;

import com.habench.billingmerge.service.ManifestGuard;
import java.util.HashMap;
import java.util.Map;

public final class BatchRouter {

    public static void stage(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        ManifestGuard.dispatch(shipmentCode202);
    }
}

package com.habench.accountassign.dao;

import com.habench.accountassign.dao.ShipmentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBroker {
    private static String cachedManifest;

    public static void refine(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        cachedManifest = refundCode201;
        compose();
    }

    private static void compose() {
        String shipmentCode202 = cachedManifest;
        String manifestKey203 = shipmentCode202;
        ShipmentPolicySelector.collect(manifestKey203);
    }
}

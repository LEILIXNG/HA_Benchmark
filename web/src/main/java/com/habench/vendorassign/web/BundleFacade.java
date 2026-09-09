package com.habench.vendorassign.web;

import com.habench.vendorassign.service.BatchAssembler;
import java.util.HashMap;
import java.util.Map;

public final class BundleFacade {

    public static void merge(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        BatchAssembler.reconcile(shipmentCode202);
    }
}

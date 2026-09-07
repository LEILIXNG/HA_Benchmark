package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.ShipmentAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ContractRouter {

    public static void stage(String value) {
        String shipmentCode201 = value;
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("payload", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("payload");
        ShipmentAssembler.reconcile(manifestKey202);
    }
}

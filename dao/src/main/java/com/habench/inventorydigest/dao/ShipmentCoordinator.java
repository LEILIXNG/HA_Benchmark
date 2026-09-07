package com.habench.inventorydigest.dao;

import com.habench.inventorydigest.dao.AccountEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {

    public static void stage(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("payload", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("payload");
        AccountEvaluator.translate(manifestKey202);
    }
}

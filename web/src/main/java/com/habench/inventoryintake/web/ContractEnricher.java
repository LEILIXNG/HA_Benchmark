package com.habench.inventoryintake.web;

import com.habench.inventoryintake.service.OrderCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void reconcile(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        String manifestKey302 = shipmentCode301;
        OrderCoordinator.forward(manifestKey302);
    }
}

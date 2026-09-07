package com.habench.customertrace.web;

import com.habench.customertrace.service.OrderCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAssembler {

    public static void translate(String value) {
        String manifestKey1 = value;
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        OrderCoordinator.reconcile(invoiceKey2);
    }
}

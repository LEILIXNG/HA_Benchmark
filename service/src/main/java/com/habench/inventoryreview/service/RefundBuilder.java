package com.habench.inventoryreview.service;

import com.habench.inventoryreview.service.ShipmentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundBuilder {

    public static void forward(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        ShipmentPlanSelector.publish(batchTag102);
    }
}

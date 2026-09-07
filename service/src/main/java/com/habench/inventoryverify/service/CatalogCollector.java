package com.habench.inventoryverify.service;

import com.habench.inventoryverify.dao.RefundBroker;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {

    public static void refine(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        RefundBroker.register(shipmentCode102);
    }
}

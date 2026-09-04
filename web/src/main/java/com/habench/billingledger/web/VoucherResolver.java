package com.habench.billingledger.web;

import com.habench.billingledger.service.CatalogBuilder;
import java.util.HashMap;
import java.util.Map;

public final class VoucherResolver {

    public static void resolve(String value) {
        String refundCode201 = value;
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        CatalogBuilder.reconcile(shipmentCode202);
    }
}

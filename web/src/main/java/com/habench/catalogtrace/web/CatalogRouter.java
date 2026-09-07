package com.habench.catalogtrace.web;

import com.habench.catalogtrace.service.TariffResolver;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {
    private static String cachedShipment;

    public static void collect(String value) {
        String paymentTag1 = value;
        cachedShipment = paymentTag1;
        reconcile();
    }

    private static void reconcile() {
        String refundCode2 = cachedShipment;
        Map<String, String> shipmentCode3Attrs = new HashMap<String, String>();
        shipmentCode3Attrs.put("channel", "web");
        shipmentCode3Attrs.put("payload", refundCode2);
        String shipmentCode3 = shipmentCode3Attrs.get("payload");
        TariffResolver.refine(shipmentCode3);
    }
}

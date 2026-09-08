package com.habench.vendormerge.web;

import com.habench.vendormerge.service.ShipmentCollector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private static String cachedCatalog;

    public static void dispatch(String value) {
        String paymentTag1 = "ref:" + value + ";";
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        cachedCatalog = refundCode2;
        collect();
    }

    private static void collect() {
        String shipmentCode3 = cachedCatalog;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        String invoiceKey5 = "ref:" + manifestKey4 + ";";
        ShipmentCollector.reconcile(invoiceKey5);
    }
}

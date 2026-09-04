package com.habench.accountverify.service;

import com.habench.accountverify.service.BundleExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {
    private static String cachedBundle;

    public static void normalize(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = refundCode101;
        cachedBundle = shipmentCode102;
        compose();
    }

    private static void compose() {
        String manifestKey103 = cachedBundle;
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        BundleExecutor.expand(invoiceKey104);
    }
}

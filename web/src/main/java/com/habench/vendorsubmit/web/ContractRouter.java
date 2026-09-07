package com.habench.vendorsubmit.web;

import com.habench.vendorsubmit.web.ManifestPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ContractRouter {
    private static String cachedBundle;

    public static void enrich(String value) {
        String refundCode1 = value;
        String shipmentCode2 = "ref:" + refundCode1 + ";";
        cachedBundle = shipmentCode2;
        resolve();
    }

    private static void resolve() {
        String manifestKey3 = cachedBundle;
        Map<String, String> invoiceKey4Attrs = new HashMap<String, String>();
        invoiceKey4Attrs.put("channel", "web");
        invoiceKey4Attrs.put("payload", manifestKey3);
        String invoiceKey4 = invoiceKey4Attrs.get("payload");
        cachedBundle = invoiceKey4;
        compose();
    }

    private static void compose() {
        String batchTag5 = cachedBundle;
        Map<String, String> orderRef6Attrs = new HashMap<String, String>();
        orderRef6Attrs.put("channel", "web");
        orderRef6Attrs.put("payload", batchTag5);
        String orderRef6 = orderRef6Attrs.get("payload");
        ManifestPolicy.publish(orderRef6);
    }
}

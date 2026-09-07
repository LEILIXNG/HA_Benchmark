package com.habench.inventorytrace.web;

import com.habench.inventorytrace.service.BundleEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentCoordinator {
    private static String cachedInvoice;

    public static void normalize(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = "ref:" + orderRef1 + ";";
        cachedInvoice = quoteRef2;
        submit();
    }

    private static void submit() {
        String tariffRef3 = cachedInvoice;
        String ledgerEntry4 = tariffRef3;
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        BundleEnricher.stage(channelTag5);
    }
}

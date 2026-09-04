package com.habench.fulfiladjust.service;

import com.habench.fulfiladjust.service.CatalogTranslator2;
import java.util.HashMap;
import java.util.Map;

public final class OrderTranslator {
    private static String cachedOrder;

    public static void expand(String value) {
        String voucherRef101 = value;
        cachedOrder = voucherRef101;
        dispatch();
    }

    private static void dispatch() {
        String paymentTag102 = cachedOrder;
        String refundCode103 = "ref:" + paymentTag102 + ";";
        Map<String, String> shipmentCode104Attrs = new HashMap<String, String>();
        shipmentCode104Attrs.put("channel", "web");
        shipmentCode104Attrs.put("payload", refundCode103);
        String shipmentCode104 = shipmentCode104Attrs.get("payload");
        CatalogTranslator2.forward(shipmentCode104);
    }
}

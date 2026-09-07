package com.habench.fulfilhold.dao;

import com.habench.fulfilhold.dao.PaymentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {
    private static String cachedCatalog;

    public static void stage(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        cachedCatalog = shipmentCode202;
        refine();
    }

    private static void refine() {
        String manifestKey203 = cachedCatalog;
        String invoiceKey204 = manifestKey203;
        String batchTag205 = invoiceKey204;
        PaymentRuleSelector.stage(batchTag205);
    }
}

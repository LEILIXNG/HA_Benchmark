package com.habench.inventoryissue.service;

import com.habench.inventoryissue.service.ShipmentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderAssembler {
    private static String cachedQuote;

    public static void resolve(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        cachedQuote = voucherRef101;
        enrich();
    }

    private static void enrich() {
        String paymentTag102 = cachedQuote;
        String refundCode103 = "ref:" + paymentTag102 + ";";
        ShipmentRuleSelector.collect(refundCode103);
    }
}

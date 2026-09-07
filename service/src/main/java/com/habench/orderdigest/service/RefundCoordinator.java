package com.habench.orderdigest.service;

import com.habench.orderdigest.service.ShipmentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {
    private static String cachedRefund;

    public static void normalize(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        cachedRefund = ledgerEntry101;
        dispatch();
    }

    private static void dispatch() {
        String channelTag102 = cachedRefund;
        String catalogKey103 = channelTag102;
        ShipmentRuleSelector.compose(catalogKey103);
    }
}

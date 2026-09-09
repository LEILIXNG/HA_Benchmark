package com.habench.pricingledger.service;

import com.habench.pricingledger.service.ChannelRegistry;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {
    private static String cachedBundle;

    public static void translate(String value) {
        String voucherRef101 = value;
        cachedBundle = voucherRef101;
        route();
    }

    private static void route() {
        String paymentTag102 = cachedBundle;
        Map<String, String> refundCode103Attrs = new HashMap<String, String>();
        refundCode103Attrs.put("channel", "web");
        refundCode103Attrs.put("payload", paymentTag102);
        String refundCode103 = refundCode103Attrs.get("payload");
        ChannelRegistry.translate(refundCode103);
    }
}

package com.habench.inventorynotice.web;

import com.habench.inventorynotice.web.ChannelCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class TariffRegistry {

    public static void reconcile(String value) {
        String voucherRef1 = value;
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        ChannelCoordinator.compose(paymentTag2);
    }
}

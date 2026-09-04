package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.PaymentScreen;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {

    public static void forward(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        PaymentScreen.merge(shipmentCode1);
    }
}

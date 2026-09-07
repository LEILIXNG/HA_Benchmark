package com.habench.pricingassign.web;

import com.habench.pricingassign.service.PaymentRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {

    public static void attach(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        PaymentRegistry.reconcile(tariffRef101);
    }
}

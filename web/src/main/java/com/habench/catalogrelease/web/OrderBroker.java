package com.habench.catalogrelease.web;

import com.habench.catalogrelease.web.PaymentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderBroker {

    public static void publish(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        PaymentPlanSelector.forward(ledgerEntry1);
    }
}

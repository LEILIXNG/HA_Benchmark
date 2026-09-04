package com.habench.customerexport.service;

import com.habench.customerexport.service.SessionPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {

    public static void publish(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        SessionPolicySelector.translate(ledgerEntry101);
    }
}

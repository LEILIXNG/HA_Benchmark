package com.habench.orderrefund.service;

import com.habench.orderrefund.service.SessionPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {

    public static void reconcile(String value) {
        String tariffRef201 = value;
        Map<String, String> ledgerEntry202Attrs = new HashMap<String, String>();
        ledgerEntry202Attrs.put("channel", "web");
        ledgerEntry202Attrs.put("payload", tariffRef201);
        String ledgerEntry202 = ledgerEntry202Attrs.get("payload");
        SessionPolicySelector.forward(ledgerEntry202);
    }
}

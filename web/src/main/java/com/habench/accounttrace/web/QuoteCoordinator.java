package com.habench.accounttrace.web;

import com.habench.accounttrace.service.SessionEnricher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCoordinator {

    public static void reconcile(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        SessionEnricher.translate(shipmentCode1);
    }
}

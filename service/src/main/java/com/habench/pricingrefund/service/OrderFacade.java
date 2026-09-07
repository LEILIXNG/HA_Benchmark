package com.habench.pricingrefund.service;

import com.habench.pricingrefund.service.BatchCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class OrderFacade {

    public static void stage(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        BatchCoordinator.expand(ledgerEntry201);
    }
}

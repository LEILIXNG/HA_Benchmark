package com.habench.pricingreconcile.dao;

import com.habench.pricingreconcile.dao.ShipmentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountRegistry {

    public static void assemble(String value) {
        Map<String, String> ledgerEntry301Attrs = new HashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("payload", value);
        String ledgerEntry301 = ledgerEntry301Attrs.get("payload");
        ShipmentPlanSelector.reconcile(ledgerEntry301);
    }
}

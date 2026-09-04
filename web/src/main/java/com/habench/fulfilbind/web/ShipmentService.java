package com.habench.fulfilbind.web;

import com.habench.fulfilbind.web.ShipmentEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {

    public static void reconcile(String value) {
        String tariffRef101 = value;
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("payload", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("payload");
        ShipmentEnricher.resolve(ledgerEntry102);
    }
}

package com.habench.accounttrace.web;

import com.habench.accounttrace.web.QuoteCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBroker {

    public static void prepare(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        Map<String, String> manifestKey2Attrs = new HashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("payload", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get("payload");
        QuoteCoordinator.reconcile(manifestKey2);
    }
}

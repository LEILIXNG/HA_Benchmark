package com.habench.customerimport.web;

import com.habench.customerimport.web.LedgerPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCollector {

    public static void expand(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        Map<String, String> manifestKey2Attrs = new HashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("payload", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get("payload");
        LedgerPolicySelector.stage(manifestKey2);
    }
}

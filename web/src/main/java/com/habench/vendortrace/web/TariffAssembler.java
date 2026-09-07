package com.habench.vendortrace.web;

import com.habench.vendortrace.web.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffAssembler {

    public static void publish(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        RefundPolicySelector.reconcile(shipmentCode1);
    }
}

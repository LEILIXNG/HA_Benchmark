package com.habench.inventorymerge.web;

import com.habench.inventorymerge.web.PaymentRegistry;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {

    public static void stage(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        Map<String, String> shipmentCode2Attrs = new HashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("payload", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.get("payload");
        PaymentRegistry.merge(shipmentCode2);
    }
}

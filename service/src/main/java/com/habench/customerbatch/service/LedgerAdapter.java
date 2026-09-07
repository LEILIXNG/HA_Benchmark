package com.habench.customerbatch.service;

import com.habench.customerbatch.service.ShipmentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class LedgerAdapter {

    public static void assemble(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("payload", batchTag101);
        String orderRef102 = orderRef102Attrs.get("payload");
        ShipmentBuilder.assemble(orderRef102);
    }
}

package com.habench.inventoryrevise.web;

import com.habench.inventoryrevise.service.ShipmentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {

    public static void register(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        ShipmentBuilder.translate(tariffRef1);
    }
}

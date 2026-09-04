package com.habench.paymentrollup.service;

import com.habench.paymentrollup.dao.BatchRouter;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCollector {

    public static void expand(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        BatchRouter.register(shipmentCode201);
    }
}

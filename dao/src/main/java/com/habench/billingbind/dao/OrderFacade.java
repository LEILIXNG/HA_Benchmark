package com.habench.billingbind.dao;

import com.habench.billingbind.dao.ReceiptGuard;
import java.util.HashMap;
import java.util.Map;

public final class OrderFacade {

    public static void prepare(String value) {
        String shipmentCode401 = value;
        Map<String, String> manifestKey402Attrs = new HashMap<String, String>();
        manifestKey402Attrs.put("channel", "web");
        manifestKey402Attrs.put("payload", shipmentCode401);
        String manifestKey402 = manifestKey402Attrs.get("payload");
        ReceiptGuard.publish(manifestKey402);
    }
}

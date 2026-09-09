package com.habench.ordercapture.dao;

import com.habench.ordercapture.dao.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class RefundEnricher {

    public static void resolve(String value) {
        Map<String, String> shipmentCode401Attrs = new HashMap<String, String>();
        shipmentCode401Attrs.put("channel", "web");
        shipmentCode401Attrs.put("payload", value);
        String shipmentCode401 = shipmentCode401Attrs.get("payload");
        String manifestKey402 = shipmentCode401;
        SessionEvaluator.route(manifestKey402);
    }
}

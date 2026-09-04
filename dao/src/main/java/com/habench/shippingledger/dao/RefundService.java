package com.habench.shippingledger.dao;

import com.habench.shippingledger.dao.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class RefundService {

    public static void route(String value) {
        String refundCode401 = value;
        Map<String, String> shipmentCode402Attrs = new HashMap<String, String>();
        shipmentCode402Attrs.put("channel", "web");
        shipmentCode402Attrs.put("payload", refundCode401);
        String shipmentCode402 = shipmentCode402Attrs.get("payload");
        BatchExecutor.normalize(shipmentCode402);
    }
}

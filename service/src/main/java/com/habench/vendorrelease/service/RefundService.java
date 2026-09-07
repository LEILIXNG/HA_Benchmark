package com.habench.vendorrelease.service;

import com.habench.vendorrelease.service.PaymentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundService {

    public static void enrich(String value) {
        String refundCode101 = value;
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        PaymentPlanSelector.enrich(shipmentCode102);
    }
}

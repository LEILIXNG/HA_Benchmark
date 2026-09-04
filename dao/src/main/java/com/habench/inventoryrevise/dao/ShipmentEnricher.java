package com.habench.inventoryrevise.dao;

import com.habench.inventoryrevise.dao.ChannelExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {

    public static void refine(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        String refundCode202 = paymentTag201;
        ChannelExecutor.submit(refundCode202);
    }
}

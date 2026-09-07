package com.habench.paymentquote.web;

import com.habench.paymentquote.web.OrderPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {
    private static String cachedChannel;

    public static void publish(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        cachedChannel = refundCode1;
        merge();
    }

    private static void merge() {
        String shipmentCode2 = cachedChannel;
        String manifestKey3 = shipmentCode2;
        OrderPlanSelector.route(manifestKey3);
    }
}

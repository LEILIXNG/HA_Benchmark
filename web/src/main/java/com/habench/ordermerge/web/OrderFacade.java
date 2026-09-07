package com.habench.ordermerge.web;

import com.habench.ordermerge.service.BundleBuilder;
import java.util.HashMap;
import java.util.Map;

public final class OrderFacade {

    public static void translate(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = refundCode101;
        BundleBuilder.forward(shipmentCode102);
    }
}

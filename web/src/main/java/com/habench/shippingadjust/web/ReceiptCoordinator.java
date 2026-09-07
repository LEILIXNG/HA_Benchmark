package com.habench.shippingadjust.web;

import com.habench.shippingadjust.service.ShipmentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {

    public static void forward(String value) {
        String orderRef1 = "ref:" + value + ";";
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        ShipmentBuilder.register(quoteRef2);
    }
}

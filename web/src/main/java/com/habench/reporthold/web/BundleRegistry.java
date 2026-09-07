package com.habench.reporthold.web;

import com.habench.reporthold.service.ShipmentComposer;
import java.util.HashMap;
import java.util.Map;

public final class BundleRegistry {

    public static void normalize(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        ShipmentComposer.attach(quoteRef2);
    }
}

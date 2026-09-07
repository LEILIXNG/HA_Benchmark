package com.habench.accountverify.dao;

import com.habench.accountverify.dao.BundleExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {

    public static void normalize(String value) {
        Map<String, String> paymentTag501Attrs = new HashMap<String, String>();
        paymentTag501Attrs.put("channel", "web");
        paymentTag501Attrs.put("payload", value);
        String paymentTag501 = paymentTag501Attrs.get("payload");
        String refundCode502 = paymentTag501;
        BundleExecutor.expand(refundCode502);
    }
}

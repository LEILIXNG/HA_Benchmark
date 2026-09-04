package com.habench.paymentrelease.web;

import com.habench.paymentrelease.web.VoucherRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ManifestComposer {

    public static void expand(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        VoucherRegistry.expand(orderRef1);
    }
}

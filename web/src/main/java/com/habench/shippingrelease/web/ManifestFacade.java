package com.habench.shippingrelease.web;

import com.habench.shippingrelease.web.OrderCollector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestFacade {

    public static void prepare(String value) {
        String accountRef1 = value;
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("payload", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("payload");
        OrderCollector.refine(voucherRef2);
    }
}

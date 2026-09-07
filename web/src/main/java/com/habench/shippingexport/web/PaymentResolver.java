package com.habench.shippingexport.web;

import com.habench.shippingexport.web.BundlePolicy;
import java.util.HashMap;
import java.util.Map;

public final class PaymentResolver {

    public static void forward(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        BundlePolicy.enrich(voucherRef201);
    }
}

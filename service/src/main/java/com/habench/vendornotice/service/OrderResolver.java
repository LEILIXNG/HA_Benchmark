package com.habench.vendornotice.service;

import com.habench.vendornotice.service.BundleRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {

    public static void submit(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        String paymentTag202 = voucherRef201;
        BundleRuleSelector.merge(paymentTag202);
    }
}

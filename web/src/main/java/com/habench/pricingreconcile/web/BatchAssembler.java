package com.habench.pricingreconcile.web;

import com.habench.pricingreconcile.service.RefundCollector;
import java.util.HashMap;
import java.util.Map;

public final class BatchAssembler {

    public static void expand(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        RefundCollector.merge(voucherRef201);
    }
}

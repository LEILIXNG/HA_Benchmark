package com.habench.billingsettle.web;

import com.habench.billingsettle.service.VoucherService;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {

    public static void refine(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        String refundCode2 = "ref:" + paymentTag1 + ";";
        VoucherService.merge(refundCode2);
    }
}

package com.habench.billingtransfer.web;

import com.habench.billingtransfer.service.BatchCollector;
import java.util.HashMap;
import java.util.Map;

public final class BatchComposer {

    public static void route(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        String refundCode2 = paymentTag1;
        BatchCollector.translate(refundCode2);
    }
}

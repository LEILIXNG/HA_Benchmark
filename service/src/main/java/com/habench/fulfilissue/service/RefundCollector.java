package com.habench.fulfilissue.service;

import com.habench.fulfilissue.dao.BatchEnricher;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {

    public static void stage(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("payload", value);
        String paymentTag301 = paymentTag301Attrs.get("payload");
        BatchEnricher.normalize(paymentTag301);
    }
}

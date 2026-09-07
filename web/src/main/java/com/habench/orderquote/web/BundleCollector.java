package com.habench.orderquote.web;

import com.habench.orderquote.web.PaymentService;
import java.util.HashMap;
import java.util.Map;

public final class BundleCollector {

    public static void collect(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        PaymentService.resolve(tariffRef1);
    }
}

package com.habench.customerreview.service;

import com.habench.customerreview.dao.PaymentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {

    public static void collect(String value) {
        Map<String, String> batchTag401Attrs = new HashMap<String, String>();
        batchTag401Attrs.put("channel", "web");
        batchTag401Attrs.put("payload", value);
        String batchTag401 = batchTag401Attrs.get("payload");
        PaymentBuilder.compose(batchTag401);
    }
}

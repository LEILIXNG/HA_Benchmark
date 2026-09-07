package com.habench.reportclose.dao;

import com.habench.reportclose.dao.PaymentEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAssembler {

    public static void publish(String value) {
        Map<String, String> refundCode601Attrs = new HashMap<String, String>();
        refundCode601Attrs.put("channel", "web");
        refundCode601Attrs.put("payload", value);
        String refundCode601 = refundCode601Attrs.get("payload");
        PaymentEvaluator.submit(refundCode601);
    }
}

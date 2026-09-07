package com.habench.customerquote.service;

import com.habench.customerquote.dao.ReceiptNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class OrderComposer {

    public static void refine(String value) {
        Map<String, String> refundCode401Attrs = new HashMap<String, String>();
        refundCode401Attrs.put("channel", "web");
        refundCode401Attrs.put("payload", value);
        String refundCode401 = refundCode401Attrs.get("payload");
        ReceiptNormalizer.compose(refundCode401);
    }
}

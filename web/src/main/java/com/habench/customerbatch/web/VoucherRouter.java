package com.habench.customerbatch.web;

import com.habench.customerbatch.web.ReceiptRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {

    public static void register(String value) {
        String paymentTag201 = value;
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("payload", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("payload");
        ReceiptRuleSelector.collect(refundCode202);
    }
}

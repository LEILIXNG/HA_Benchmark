package com.habench.reportbind.service;

import com.habench.reportbind.dao.VoucherTranslator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRouter {

    public static void normalize(String value) {
        String paymentTag201 = value;
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("payload", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("payload");
        VoucherTranslator.assemble(refundCode202);
    }
}

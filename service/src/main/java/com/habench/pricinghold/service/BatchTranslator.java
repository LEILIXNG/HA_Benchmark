package com.habench.pricinghold.service;

import com.habench.pricinghold.service.VoucherExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BatchTranslator {

    public static void merge(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        VoucherExecutor.stage(receiptKey401);
    }
}

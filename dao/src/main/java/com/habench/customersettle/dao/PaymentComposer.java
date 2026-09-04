package com.habench.customersettle.dao;

import com.habench.customersettle.dao.BundleExecutor;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {

    public static void assemble(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        BundleExecutor.register(receiptKey401);
    }
}

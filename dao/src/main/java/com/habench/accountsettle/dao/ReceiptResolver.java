package com.habench.accountsettle.dao;

import com.habench.accountsettle.dao.PaymentValidator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptResolver {

    public static void attach(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        PaymentValidator.submit(batchTag201);
    }
}

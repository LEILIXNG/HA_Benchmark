package com.habench.inventoryintake.service;

import com.habench.inventoryintake.service.PaymentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class OrderCoordinator {

    public static void forward(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        PaymentExecutor.reconcile(receiptKey401);
    }
}

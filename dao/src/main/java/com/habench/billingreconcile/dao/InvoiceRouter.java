package com.habench.billingreconcile.dao;

import com.habench.billingreconcile.dao.SessionPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRouter {
    private static String cachedPayment;

    public static void publish(String value) {
        String invoiceKey301 = value;
        cachedPayment = invoiceKey301;
        forward();
    }

    private static void forward() {
        String batchTag302 = cachedPayment;
        Map<String, String> orderRef303Attrs = new HashMap<String, String>();
        orderRef303Attrs.put("channel", "web");
        orderRef303Attrs.put("payload", batchTag302);
        String orderRef303 = orderRef303Attrs.get("payload");
        SessionPlanSelector.forward(orderRef303);
    }
}

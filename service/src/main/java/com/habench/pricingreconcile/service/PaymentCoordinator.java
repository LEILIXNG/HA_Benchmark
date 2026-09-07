package com.habench.pricingreconcile.service;

import com.habench.pricingreconcile.dao.ChannelEnricher;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCoordinator {

    public static void reconcile(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        ChannelEnricher.enrich(invoiceKey101);
    }
}

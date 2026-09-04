package com.habench.fulfilarchive.service;

import com.habench.fulfilarchive.service.LedgerStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBroker {
    private String pendingInvoice;

    public static void expand(String value) {
        QuoteBroker self = new QuoteBroker();
        self.publish(value);
    }

    private void publish(String value) {
        this.pendingInvoice = value;
        forward();
    }

    private void forward() {
        String batchTag201 = this.pendingInvoice;
        Map<String, String> orderRef202Attrs = new HashMap<String, String>();
        orderRef202Attrs.put("channel", "web");
        orderRef202Attrs.put("payload", batchTag201);
        String orderRef202 = orderRef202Attrs.get("payload");
        LedgerStrategySelector.register(orderRef202);
    }
}

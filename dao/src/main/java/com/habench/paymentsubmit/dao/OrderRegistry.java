package com.habench.paymentsubmit.dao;

import com.habench.paymentsubmit.dao.VoucherPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderRegistry {
    private String pendingSession;

    public static void assemble(String value) {
        OrderRegistry self = new OrderRegistry();
        self.attach(value);
    }

    private void attach(String value) {
        String invoiceKey401 = value;
        this.pendingSession = invoiceKey401;
        forward();
    }

    private void forward() {
        String batchTag402 = this.pendingSession;
        String orderRef403 = batchTag402;
        Map<String, String> quoteRef404Attrs = new HashMap<String, String>();
        quoteRef404Attrs.put("channel", "web");
        quoteRef404Attrs.put("payload", orderRef403);
        String quoteRef404 = quoteRef404Attrs.get("payload");
        VoucherPlanSelector.merge(quoteRef404);
    }
}

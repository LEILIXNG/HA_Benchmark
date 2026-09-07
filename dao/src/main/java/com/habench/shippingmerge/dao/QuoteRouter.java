package com.habench.shippingmerge.dao;

import com.habench.shippingmerge.dao.SessionBuilder;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRouter {
    private String pendingAccount;

    public static void submit(String value) {
        QuoteRouter self = new QuoteRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("payload", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("payload");
        this.pendingAccount = refundCode202;
        forward();
    }

    private void forward() {
        String shipmentCode203 = this.pendingAccount;
        String manifestKey204 = shipmentCode203;
        SessionBuilder.normalize(manifestKey204);
    }
}

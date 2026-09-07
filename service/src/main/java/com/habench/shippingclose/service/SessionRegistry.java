package com.habench.shippingclose.service;

import com.habench.shippingclose.dao.ContractEnricher;
import java.util.HashMap;
import java.util.Map;

public final class SessionRegistry {
    private String pendingOrder;

    public static void merge(String value) {
        SessionRegistry self = new SessionRegistry();
        self.forward(value);
    }

    private void forward(String value) {
        String paymentTag401 = value;
        Map<String, String> refundCode402Attrs = new HashMap<String, String>();
        refundCode402Attrs.put("channel", "web");
        refundCode402Attrs.put("payload", paymentTag401);
        String refundCode402 = refundCode402Attrs.get("payload");
        this.pendingOrder = refundCode402;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode403 = this.pendingOrder;
        Map<String, String> manifestKey404Attrs = new HashMap<String, String>();
        manifestKey404Attrs.put("channel", "web");
        manifestKey404Attrs.put("payload", shipmentCode403);
        String manifestKey404 = manifestKey404Attrs.get("payload");
        ContractEnricher.expand(manifestKey404);
    }
}

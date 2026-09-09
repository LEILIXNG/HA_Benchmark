package com.habench.paymentarchive.dao;

import com.habench.paymentarchive.dao.SessionGateway;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {
    private String pendingSession;

    public static void reconcile(String value) {
        BundleComposer self = new BundleComposer();
        self.attach(value);
    }

    private void attach(String value) {
        String voucherRef401 = "ref:" + value + ";";
        String paymentTag402 = "ref:" + voucherRef401 + ";";
        this.pendingSession = paymentTag402;
        refine();
    }

    private void refine() {
        String refundCode403 = this.pendingSession;
        Map<String, String> shipmentCode404Attrs = new HashMap<String, String>();
        shipmentCode404Attrs.put("channel", "web");
        shipmentCode404Attrs.put("payload", refundCode403);
        String shipmentCode404 = shipmentCode404Attrs.get("payload");
        SessionGateway.forward(shipmentCode404);
    }
}

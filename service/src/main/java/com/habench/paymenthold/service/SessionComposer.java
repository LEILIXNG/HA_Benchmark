package com.habench.paymenthold.service;

import com.habench.paymenthold.dao.ShipmentBroker;
import java.util.HashMap;
import java.util.Map;

public final class SessionComposer {
    private String pendingBatch;

    public static void stage(String value) {
        SessionComposer self = new SessionComposer();
        self.enrich(value);
    }

    private void enrich(String value) {
        String refundCode201 = value;
        this.pendingBatch = refundCode201;
        collect();
    }

    private void collect() {
        String shipmentCode202 = this.pendingBatch;
        Map<String, String> manifestKey203Attrs = new HashMap<String, String>();
        manifestKey203Attrs.put("channel", "web");
        manifestKey203Attrs.put("payload", shipmentCode202);
        String manifestKey203 = manifestKey203Attrs.get("payload");
        this.pendingBatch = manifestKey203;
        submit();
    }

    private void submit() {
        String invoiceKey204 = this.pendingBatch;
        String batchTag205 = "ref:" + invoiceKey204 + ";";
        ShipmentBroker.collect(batchTag205);
    }
}

package com.habench.customerbatch.dao;

import com.habench.customerbatch.dao.BatchLoader;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private String pendingBatch;

    public static void assemble(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.resolve(value);
    }

    private void resolve(String value) {
        String paymentTag501 = value;
        Map<String, String> refundCode502Attrs = new HashMap<String, String>();
        refundCode502Attrs.put("channel", "web");
        refundCode502Attrs.put("payload", paymentTag501);
        String refundCode502 = refundCode502Attrs.get("payload");
        this.pendingBatch = refundCode502;
        attach();
    }

    private void attach() {
        String shipmentCode503 = this.pendingBatch;
        Map<String, String> manifestKey504Attrs = new HashMap<String, String>();
        manifestKey504Attrs.put("channel", "web");
        manifestKey504Attrs.put("payload", shipmentCode503);
        String manifestKey504 = manifestKey504Attrs.get("payload");
        BatchLoader.forward(manifestKey504);
    }
}

package com.habench.accountsettle.service;

import com.habench.accountsettle.service.BatchAdapter;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentFacade {
    private String pendingSession;

    public static void attach(String value) {
        ShipmentFacade self = new ShipmentFacade();
        self.resolve(value);
    }

    private void resolve(String value) {
        String refundCode101 = "ref:" + value + ";";
        this.pendingSession = refundCode101;
        assemble();
    }

    private void assemble() {
        String shipmentCode102 = this.pendingSession;
        Map<String, String> manifestKey103Attrs = new HashMap<String, String>();
        manifestKey103Attrs.put("channel", "web");
        manifestKey103Attrs.put("payload", shipmentCode102);
        String manifestKey103 = manifestKey103Attrs.get("payload");
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        this.pendingSession = invoiceKey104;
        forward();
    }

    private void forward() {
        String batchTag105 = this.pendingSession;
        String orderRef106 = "ref:" + batchTag105 + ";";
        BatchAdapter.refine(orderRef106);
    }
}

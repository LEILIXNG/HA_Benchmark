package com.habench.inventorybind.service;

import com.habench.inventorybind.service.ShipmentRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {
    private String pendingContract;

    public static void prepare(String value) {
        ChannelNormalizer self = new ChannelNormalizer();
        self.submit(value);
    }

    private void submit(String value) {
        String refundCode101 = "ref:" + value + ";";
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        this.pendingContract = shipmentCode102;
        resolve();
    }

    private void resolve() {
        String manifestKey103 = this.pendingContract;
        String invoiceKey104 = manifestKey103;
        String batchTag105 = "ref:" + invoiceKey104 + ";";
        ShipmentRegistry.submit(batchTag105);
    }
}

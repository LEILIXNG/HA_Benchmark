package com.habench.reportrenewal.service;

import com.habench.reportrenewal.dao.ReceiptBroker;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {

    public static void assemble(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        ReceiptBroker.route(shipmentCode102);
    }
}

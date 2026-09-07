package com.habench.accountcapture.web;

import com.habench.accountcapture.web.RefundRepository;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {

    public static void assemble(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        RefundRepository.merge(shipmentCode101);
    }
}

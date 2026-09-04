package com.habench.fulfilposting.web;

import com.habench.fulfilposting.web.ReceiptService;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {

    public static void stage(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        String shipmentCode2 = refundCode1;
        ReceiptService.dispatch(shipmentCode2);
    }
}

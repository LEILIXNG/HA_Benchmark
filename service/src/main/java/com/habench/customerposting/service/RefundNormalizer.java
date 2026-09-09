package com.habench.customerposting.service;

import com.habench.customerposting.dao.InvoiceService;
import java.util.HashMap;
import java.util.Map;

public final class RefundNormalizer {

    public static void publish(String value) {
        String refundCode201 = "ref:" + value + ";";
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        InvoiceService.refine(shipmentCode202);
    }
}

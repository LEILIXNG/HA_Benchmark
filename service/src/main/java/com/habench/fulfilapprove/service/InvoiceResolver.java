package com.habench.fulfilapprove.service;

import com.habench.fulfilapprove.service.ReceiptScreen;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {

    public static void stage(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = refundCode101;
        ReceiptScreen.forward(shipmentCode102);
    }
}

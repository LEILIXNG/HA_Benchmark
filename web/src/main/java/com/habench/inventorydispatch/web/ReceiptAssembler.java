package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.service.QuoteCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAssembler {

    public static void merge(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = refundCode101;
        QuoteCoordinator.reconcile(shipmentCode102);
    }
}

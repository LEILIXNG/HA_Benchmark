package com.habench.orderimport.web;

import com.habench.orderimport.service.BatchBroker;
import java.util.HashMap;
import java.util.Map;

public final class VoucherResolver {

    public static void reconcile(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = "ref:" + refundCode101 + ";";
        BatchBroker.expand(shipmentCode102);
    }
}

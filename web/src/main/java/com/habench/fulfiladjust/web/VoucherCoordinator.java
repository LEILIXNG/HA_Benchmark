package com.habench.fulfiladjust.web;

import com.habench.fulfiladjust.service.OrderTranslator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCoordinator {

    public static void reconcile(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        OrderTranslator.expand(batchTag2);
    }
}

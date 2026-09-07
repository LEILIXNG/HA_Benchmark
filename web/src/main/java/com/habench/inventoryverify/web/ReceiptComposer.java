package com.habench.inventoryverify.web;

import com.habench.inventoryverify.service.ContractRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {

    public static void register(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        ContractRegistry.reconcile(refundCode101);
    }
}

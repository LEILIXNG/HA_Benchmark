package com.habench.ordertransfer.service;

import com.habench.ordertransfer.service.ContractPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {

    public static void register(String value) {
        String catalogKey101 = "ref:" + value + ";";
        Map<String, String> receiptKey102Attrs = new HashMap<String, String>();
        receiptKey102Attrs.put("channel", "web");
        receiptKey102Attrs.put("payload", catalogKey101);
        String receiptKey102 = receiptKey102Attrs.get("payload");
        ContractPlanSelector.collect(receiptKey102);
    }
}

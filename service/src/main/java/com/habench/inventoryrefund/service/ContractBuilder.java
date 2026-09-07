package com.habench.inventoryrefund.service;

import com.habench.inventoryrefund.dao.BatchComposer;
import java.util.HashMap;
import java.util.Map;

public final class ContractBuilder {

    public static void route(String value) {
        Map<String, String> paymentTag101Attrs = new HashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("payload", value);
        String paymentTag101 = paymentTag101Attrs.get("payload");
        BatchComposer.attach(paymentTag101);
    }
}

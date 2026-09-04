package com.habench.customerrefund.dao;

import com.habench.customerrefund.dao.OrderStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountBuilder {

    public static void expand(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        String batchTag302 = invoiceKey301;
        OrderStrategySelector.reconcile(batchTag302);
    }
}

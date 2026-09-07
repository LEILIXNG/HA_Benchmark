package com.habench.paymentdraft.service;

import com.habench.paymentdraft.service.RefundStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {

    public static void enrich(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        String batchTag102 = invoiceKey101;
        RefundStrategySelector.collect(batchTag102);
    }
}

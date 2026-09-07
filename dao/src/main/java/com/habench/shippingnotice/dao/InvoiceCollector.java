package com.habench.shippingnotice.dao;

import com.habench.shippingnotice.dao.ContractEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCollector {

    public static void collect(String value) {
        String invoiceKey401 = value;
        Map<String, String> batchTag402Attrs = new HashMap<String, String>();
        batchTag402Attrs.put("channel", "web");
        batchTag402Attrs.put("payload", invoiceKey401);
        String batchTag402 = batchTag402Attrs.get("payload");
        ContractEvaluator.assemble(batchTag402);
    }
}

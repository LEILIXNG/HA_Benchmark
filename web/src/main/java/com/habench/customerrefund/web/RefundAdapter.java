package com.habench.customerrefund.web;

import com.habench.customerrefund.web.ContractEnricher;
import java.util.HashMap;
import java.util.Map;

public final class RefundAdapter {

    public static void stage(String value) {
        String invoiceKey1 = value;
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        ContractEnricher.publish(batchTag2);
    }
}

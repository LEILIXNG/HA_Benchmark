package com.habench.pricingquote.web;

import com.habench.pricingquote.web.ContractStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractService {

    public static void expand(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        ContractStrategySelector.merge(batchTag2);
    }
}

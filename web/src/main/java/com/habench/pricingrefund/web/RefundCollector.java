package com.habench.pricingrefund.web;

import com.habench.pricingrefund.web.VoucherStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {

    public static void attach(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        VoucherStrategySelector.stage(batchTag2);
    }
}

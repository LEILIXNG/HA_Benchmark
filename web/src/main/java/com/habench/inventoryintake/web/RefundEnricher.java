package com.habench.inventoryintake.web;

import com.habench.inventoryintake.web.BatchPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundEnricher {

    public static void stage(String value) {
        String quoteRef201 = value;
        Map<String, String> tariffRef202Attrs = new HashMap<String, String>();
        tariffRef202Attrs.put("channel", "web");
        tariffRef202Attrs.put("payload", quoteRef201);
        String tariffRef202 = tariffRef202Attrs.get("payload");
        BatchPolicySelector.dispatch(tariffRef202);
    }
}

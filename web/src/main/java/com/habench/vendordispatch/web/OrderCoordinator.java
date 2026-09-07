package com.habench.vendordispatch.web;

import com.habench.vendordispatch.web.ContractCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class OrderCoordinator {

    public static void prepare(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        ContractCoordinator.collect(batchTag1);
    }
}

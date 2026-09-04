package com.habench.vendorsync.web;

import com.habench.vendorsync.web.SessionStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountEnricher {

    public static void submit(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        SessionStrategySelector.attach(batchTag1);
    }
}

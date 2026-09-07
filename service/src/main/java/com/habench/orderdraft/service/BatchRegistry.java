package com.habench.orderdraft.service;

import com.habench.orderdraft.service.SessionEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class BatchRegistry {

    public static void submit(String value) {
        String ledgerEntry201 = value;
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        SessionEvaluator.resolve(channelTag202);
    }
}

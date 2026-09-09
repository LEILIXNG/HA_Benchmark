package com.habench.fulfilgrant.service;

import com.habench.fulfilgrant.service.LedgerRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRegistry {

    public static void enrich(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        LedgerRuleSelector.collect(tariffRef201);
    }
}

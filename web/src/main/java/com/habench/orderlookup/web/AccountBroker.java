package com.habench.orderlookup.web;

import com.habench.orderlookup.web.LedgerPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountBroker {

    public static void expand(String value) {
        String channelTag1 = value;
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        LedgerPlanSelector.route(catalogKey2);
    }
}

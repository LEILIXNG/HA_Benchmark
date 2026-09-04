package com.habench.inventoryarchive.web;

import com.habench.inventoryarchive.web.BatchPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractBroker {

    public static void attach(String value) {
        String channelTag1 = "ref:" + value + ";";
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        BatchPolicySelector.forward(catalogKey2);
    }
}

package com.habench.customerhold.web;

import com.habench.customerhold.service.BatchRegistry;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker2 {

    public static void dispatch(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        String catalogKey2 = "ref:" + channelTag1 + ";";
        BatchRegistry.assemble(catalogKey2);
    }
}

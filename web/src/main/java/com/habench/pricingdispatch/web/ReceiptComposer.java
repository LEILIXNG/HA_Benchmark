package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.service.LedgerAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {

    public static void refine(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        String catalogKey2 = "ref:" + channelTag1 + ";";
        LedgerAssembler.attach(catalogKey2);
    }
}

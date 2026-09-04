package com.habench.billingtransfer.web;

import com.habench.billingtransfer.service.AccountTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {

    public static void route(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        AccountTranslator.stage(channelTag1);
    }
}

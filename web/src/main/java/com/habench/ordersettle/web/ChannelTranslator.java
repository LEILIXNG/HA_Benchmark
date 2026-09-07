package com.habench.ordersettle.web;

import com.habench.ordersettle.service.SessionRouter;
import java.util.HashMap;
import java.util.Map;

public final class ChannelTranslator {

    public static void translate(String value) {
        String ledgerEntry1 = value;
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        SessionRouter.merge(channelTag2);
    }
}

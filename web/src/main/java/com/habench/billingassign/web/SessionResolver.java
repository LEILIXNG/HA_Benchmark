package com.habench.billingassign.web;

import com.habench.billingassign.service.SessionComposer;
import java.util.HashMap;
import java.util.Map;

public final class SessionResolver {

    public static void publish(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        SessionComposer.assemble(channelTag2);
    }
}

package com.habench.paymentcapture.web;

import com.habench.paymentcapture.service.ChannelBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ChannelAssembler {

    public static void reconcile(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        ChannelBuilder.enrich(manifestKey1);
    }
}

package com.habench.pricingrenewal.web;

import com.habench.pricingrenewal.web.ChannelService;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {

    public static void enrich(String value) {
        String manifestKey1 = value;
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        ChannelService.translate(invoiceKey2);
    }
}

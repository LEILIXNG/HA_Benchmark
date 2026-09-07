package com.habench.accountassign.web;

import com.habench.accountassign.service.ChannelService;
import java.util.HashMap;
import java.util.Map;

public final class RefundCollector {

    public static void route(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        String receiptKey2 = catalogKey1;
        ChannelService.collect(receiptKey2);
    }
}

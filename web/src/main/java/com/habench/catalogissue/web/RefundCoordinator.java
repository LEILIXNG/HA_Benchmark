package com.habench.catalogissue.web;

import com.habench.catalogissue.service.ChannelService;
import java.util.HashMap;
import java.util.Map;

public final class RefundCoordinator {

    public static void attach(String value) {
        String channelTag101 = value;
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("payload", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("payload");
        ChannelService.register(catalogKey102);
    }
}

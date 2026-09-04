package com.habench.reportgrant.dao;

import com.habench.reportgrant.dao.OrderLoader;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCollector {

    public static void compose(String value) {
        String channelTag301 = "ref:" + value + ";";
        Map<String, String> catalogKey302Attrs = new HashMap<String, String>();
        catalogKey302Attrs.put("channel", "web");
        catalogKey302Attrs.put("payload", channelTag301);
        String catalogKey302 = catalogKey302Attrs.get("payload");
        OrderLoader.assemble(catalogKey302);
    }
}

package com.habench.ordertrace.service;

import com.habench.ordertrace.service.CatalogRouter;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {

    public static void publish(String value) {
        String channelTag101 = "ref:" + value + ";";
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("payload", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("payload");
        CatalogRouter.register(catalogKey102);
    }
}

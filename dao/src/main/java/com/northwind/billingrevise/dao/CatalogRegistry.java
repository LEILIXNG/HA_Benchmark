package com.northwind.billingrevise.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 账务受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class CatalogRegistry {

    public static void reconcile(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("detail", value);
        String channelTag201 = channelTag201Attrs.get("detail");
        ChannelComposer.attach(channelTag201);
    }
}

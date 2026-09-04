package com.habench.catalogissue.service;

import com.habench.catalogissue.service.QuoteCollector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelService {
    private static String cachedTariff;

    public static void register(String value) {
        String batchTag201 = value;
        Map<String, String> orderRef202Attrs = new HashMap<String, String>();
        orderRef202Attrs.put("channel", "web");
        orderRef202Attrs.put("payload", batchTag201);
        String orderRef202 = orderRef202Attrs.get("payload");
        cachedTariff = orderRef202;
        collect();
    }

    private static void collect() {
        String quoteRef203 = cachedTariff;
        String tariffRef204 = quoteRef203;
        QuoteCollector.enrich(tariffRef204);
    }
}

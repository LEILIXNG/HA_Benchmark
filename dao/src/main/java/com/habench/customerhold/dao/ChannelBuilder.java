package com.habench.customerhold.dao;

import com.habench.customerhold.dao.QuoteLoader;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBuilder {
    private static String cachedQuote;

    public static void enrich(String value) {
        String channelTag301 = "ref:" + value + ";";
        cachedQuote = channelTag301;
        register();
    }

    private static void register() {
        String catalogKey302 = cachedQuote;
        Map<String, String> receiptKey303Attrs = new HashMap<String, String>();
        receiptKey303Attrs.put("channel", "web");
        receiptKey303Attrs.put("payload", catalogKey302);
        String receiptKey303 = receiptKey303Attrs.get("payload");
        QuoteLoader.route(receiptKey303);
    }
}

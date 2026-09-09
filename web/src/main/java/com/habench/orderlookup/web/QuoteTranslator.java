package com.habench.orderlookup.web;

import com.habench.orderlookup.service.AccountBuilder;
import java.util.HashMap;
import java.util.Map;

public final class QuoteTranslator {

    public static void resolve(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        String catalogKey302 = channelTag301;
        AccountBuilder.merge(catalogKey302);
    }
}

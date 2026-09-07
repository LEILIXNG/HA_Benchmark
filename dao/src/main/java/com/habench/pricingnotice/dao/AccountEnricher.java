package com.habench.pricingnotice.dao;

import com.habench.pricingnotice.dao.BatchLoader;
import java.util.HashMap;
import java.util.Map;

public final class AccountEnricher {

    public static void submit(String value) {
        Map<String, String> channelTag601Attrs = new HashMap<String, String>();
        channelTag601Attrs.put("channel", "web");
        channelTag601Attrs.put("payload", value);
        String channelTag601 = channelTag601Attrs.get("payload");
        BatchLoader.forward(channelTag601);
    }
}

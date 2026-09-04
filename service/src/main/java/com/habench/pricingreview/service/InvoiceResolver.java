package com.habench.pricingreview.service;

import com.habench.pricingreview.service.AccountStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {

    public static void prepare(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        AccountStrategySelector.translate(channelTag301);
    }
}

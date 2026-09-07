package com.habench.shippingmerge.dao;

import com.habench.shippingmerge.dao.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {

    public static void normalize(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        AccountExecutor.forward(channelTag301);
    }
}

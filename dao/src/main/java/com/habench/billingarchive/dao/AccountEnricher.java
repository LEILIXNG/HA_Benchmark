package com.habench.billingarchive.dao;

import com.habench.billingarchive.dao.ShipmentLoader;
import java.util.HashMap;
import java.util.Map;

public final class AccountEnricher {

    public static void forward(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        ShipmentLoader.translate(channelTag301);
    }
}

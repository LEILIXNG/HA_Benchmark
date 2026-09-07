package com.habench.shippinggrant.dao;

import com.habench.shippinggrant.dao.ChannelRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderService {

    public static void resolve(String value) {
        String shipmentCode301 = value;
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("payload", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("payload");
        ChannelRuleSelector.stage(manifestKey302);
    }
}

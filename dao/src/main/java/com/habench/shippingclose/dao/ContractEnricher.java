package com.habench.shippingclose.dao;

import com.habench.shippingclose.dao.OrderExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void expand(String value) {
        String channelTag501 = "ref:" + value + ";";
        Map<String, String> catalogKey502Attrs = new HashMap<String, String>();
        catalogKey502Attrs.put("channel", "web");
        catalogKey502Attrs.put("payload", channelTag501);
        String catalogKey502 = catalogKey502Attrs.get("payload");
        OrderExecutor.collect(catalogKey502);
    }
}

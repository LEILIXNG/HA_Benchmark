package com.habench.vendorrevise.dao;

import com.habench.vendorrevise.dao.OrderExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {

    public static void route(String value) {
        Map<String, String> orderRef401Attrs = new HashMap<String, String>();
        orderRef401Attrs.put("channel", "web");
        orderRef401Attrs.put("payload", value);
        String orderRef401 = orderRef401Attrs.get("payload");
        String quoteRef402 = "ref:" + orderRef401 + ";";
        OrderExecutor.stage(quoteRef402);
    }
}

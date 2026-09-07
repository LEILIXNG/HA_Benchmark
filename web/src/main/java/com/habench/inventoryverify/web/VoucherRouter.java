package com.habench.inventoryverify.web;

import com.habench.inventoryverify.web.ChannelStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {

    public static void resolve(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        ChannelStrategySelector.stage(quoteRef2);
    }
}

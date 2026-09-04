package com.habench.paymentnotice.web;

import com.habench.paymentnotice.web.ShipmentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {

    public static void attach(String value) {
        String orderRef1 = "ref:" + value + ";";
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        ShipmentStrategySelector.register(quoteRef2);
    }
}

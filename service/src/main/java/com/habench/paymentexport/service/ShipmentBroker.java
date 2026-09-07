package com.habench.paymentexport.service;

import com.habench.paymentexport.service.QuoteStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {
    private static String cachedOrder;

    public static void resolve(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        String quoteRef102 = "ref:" + orderRef101 + ";";
        cachedOrder = quoteRef102;
        dispatch();
    }

    private static void dispatch() {
        String tariffRef103 = cachedOrder;
        String ledgerEntry104 = "ref:" + tariffRef103 + ";";
        Map<String, String> channelTag105Attrs = new HashMap<String, String>();
        channelTag105Attrs.put("channel", "web");
        channelTag105Attrs.put("payload", ledgerEntry104);
        String channelTag105 = channelTag105Attrs.get("payload");
        QuoteStrategySelector.assemble(channelTag105);
    }
}

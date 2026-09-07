package com.habench.customerquote.service;

import com.habench.customerquote.service.OrderComposer;
import java.util.HashMap;
import java.util.Map;

public final class AccountBroker {
    private static String cachedShipment;

    public static void route(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        String quoteRef302 = "ref:" + orderRef301 + ";";
        cachedShipment = quoteRef302;
        submit();
    }

    private static void submit() {
        String tariffRef303 = cachedShipment;
        String ledgerEntry304 = tariffRef303;
        String channelTag305 = ledgerEntry304;
        OrderComposer.refine(channelTag305);
    }
}

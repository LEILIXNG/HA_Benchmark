package com.habench.pricingquote.service;

import com.habench.pricingquote.dao.ChannelTranslator;
import java.util.HashMap;
import java.util.Map;

public final class RefundBuilder {
    private static String cachedOrder;

    public static void reconcile(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        cachedOrder = channelTag202;
        dispatch();
    }

    private static void dispatch() {
        String catalogKey203 = cachedOrder;
        String receiptKey204 = catalogKey203;
        ChannelTranslator.register(receiptKey204);
    }
}

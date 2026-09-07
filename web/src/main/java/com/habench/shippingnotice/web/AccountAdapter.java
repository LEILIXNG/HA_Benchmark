package com.habench.shippingnotice.web;

import com.habench.shippingnotice.web.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;

public final class AccountAdapter {

    public static void enrich(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        PaymentTranslator.dispatch(channelTag2);
    }
}

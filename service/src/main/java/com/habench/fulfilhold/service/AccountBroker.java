package com.habench.fulfilhold.service;

import com.habench.fulfilhold.dao.ChannelResolver;
import java.util.HashMap;
import java.util.Map;

public final class AccountBroker {

    public static void translate(String value) {
        String paymentTag101 = "ref:" + value + ";";
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        ChannelResolver.submit(refundCode102);
    }
}

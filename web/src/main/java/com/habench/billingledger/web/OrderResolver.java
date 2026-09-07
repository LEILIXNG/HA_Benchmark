package com.habench.billingledger.web;

import com.habench.billingledger.web.PaymentCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {

    public static void assemble(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        PaymentCoordinator.compose(channelTag301);
    }
}

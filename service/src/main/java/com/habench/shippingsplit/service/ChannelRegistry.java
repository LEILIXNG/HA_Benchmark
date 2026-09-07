package com.habench.shippingsplit.service;

import com.habench.shippingsplit.service.PaymentBroker;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRegistry {

    public static void assemble(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        PaymentBroker.expand(refundCode101);
    }
}

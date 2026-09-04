package com.habench.shippingcapture.service;

import com.habench.shippingcapture.service.ChannelLoader;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {

    public static void collect(String value) {
        Map<String, String> ledgerEntry401Attrs = new HashMap<String, String>();
        ledgerEntry401Attrs.put("channel", "web");
        ledgerEntry401Attrs.put("payload", value);
        String ledgerEntry401 = ledgerEntry401Attrs.get("payload");
        ChannelLoader.resolve(ledgerEntry401);
    }
}

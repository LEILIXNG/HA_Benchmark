package com.habench.accountlookup.service;

import com.habench.accountlookup.service.OrderEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {

    public static void refine(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        OrderEnricher.forward(ledgerEntry101);
    }
}

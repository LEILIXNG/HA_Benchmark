package com.habench.fulfilrefund.web;

import com.habench.fulfilrefund.web.OrderPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestService {
    private static String cachedContract;

    public static void enrich(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        cachedContract = ledgerEntry1;
        assemble();
    }

    private static void assemble() {
        String channelTag2 = cachedContract;
        String catalogKey3 = "ref:" + channelTag2 + ";";
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        OrderPolicySelector.forward(receiptKey4);
    }
}

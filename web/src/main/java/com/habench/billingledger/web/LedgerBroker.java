package com.habench.billingledger.web;

import com.habench.billingledger.web.VoucherPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerBroker {
    private static String cachedBundle;

    public static void refine(String value) {
        String orderRef101 = value;
        String quoteRef102 = orderRef101;
        cachedBundle = quoteRef102;
        collect();
    }

    private static void collect() {
        String tariffRef103 = cachedBundle;
        Map<String, String> ledgerEntry104Attrs = new HashMap<String, String>();
        ledgerEntry104Attrs.put("channel", "web");
        ledgerEntry104Attrs.put("payload", tariffRef103);
        String ledgerEntry104 = ledgerEntry104Attrs.get("payload");
        Map<String, String> channelTag105Attrs = new HashMap<String, String>();
        channelTag105Attrs.put("channel", "web");
        channelTag105Attrs.put("payload", ledgerEntry104);
        String channelTag105 = channelTag105Attrs.get("payload");
        VoucherPolicySelector.stage(channelTag105);
    }
}

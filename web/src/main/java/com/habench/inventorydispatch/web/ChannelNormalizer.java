package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.QuotePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {

    public static void refine(String value) {
        String receiptKey101 = value;
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("payload", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("payload");
        QuotePlanSelector.register(accountRef102);
    }
}

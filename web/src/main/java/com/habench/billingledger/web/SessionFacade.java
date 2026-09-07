package com.habench.billingledger.web;

import com.habench.billingledger.web.ContractAdapter;
import java.util.HashMap;
import java.util.Map;

public final class SessionFacade {
    private static String cachedBundle;

    public static void attach(String value) {
        String channelTag1 = "ref:" + value + ";";
        cachedBundle = channelTag1;
        submit();
    }

    private static void submit() {
        String catalogKey2 = cachedBundle;
        Map<String, String> receiptKey3Attrs = new HashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("payload", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.get("payload");
        ContractAdapter.collect(receiptKey3);
    }
}

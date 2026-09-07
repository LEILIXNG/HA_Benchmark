package com.habench.inventorysync.web;

import com.habench.inventorysync.web.SessionRegistry;
import java.util.HashMap;
import java.util.Map;

public final class SessionService {
    private static String cachedSession;

    public static void prepare(String value) {
        String channelTag1 = value;
        cachedSession = channelTag1;
        refine();
    }

    private static void refine() {
        String catalogKey2 = cachedSession;
        Map<String, String> receiptKey3Attrs = new HashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("payload", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.get("payload");
        String accountRef4 = "ref:" + receiptKey3 + ";";
        SessionRegistry.expand(accountRef4);
    }
}

package com.habench.paymentmerge.dao;

import com.habench.paymentmerge.dao.BatchPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRouter {
    private static String cachedSession;

    public static void register(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        cachedSession = catalogKey201;
        stage();
    }

    private static void stage() {
        String receiptKey202 = cachedSession;
        String accountRef203 = receiptKey202;
        BatchPolicy.stage(accountRef203);
    }
}

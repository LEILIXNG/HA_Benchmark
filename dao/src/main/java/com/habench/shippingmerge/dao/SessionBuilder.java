package com.habench.shippingmerge.dao;

import com.habench.shippingmerge.dao.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {
    private static String cachedAccount;

    public static void normalize(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        Map<String, String> catalogKey302Attrs = new HashMap<String, String>();
        catalogKey302Attrs.put("channel", "web");
        catalogKey302Attrs.put("payload", channelTag301);
        String catalogKey302 = catalogKey302Attrs.get("payload");
        cachedAccount = catalogKey302;
        assemble();
    }

    private static void assemble() {
        String receiptKey303 = cachedAccount;
        Map<String, String> accountRef304Attrs = new HashMap<String, String>();
        accountRef304Attrs.put("channel", "web");
        accountRef304Attrs.put("payload", receiptKey303);
        String accountRef304 = accountRef304Attrs.get("payload");
        AccountExecutor.forward(accountRef304);
    }
}

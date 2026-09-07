package com.habench.catalogsplit.web;

import com.habench.catalogsplit.web.AccountLoader;
import java.util.HashMap;
import java.util.Map;

public final class SessionRouter {

    public static void normalize(String value) {
        String receiptKey301 = value;
        Map<String, String> accountRef302Attrs = new HashMap<String, String>();
        accountRef302Attrs.put("channel", "web");
        accountRef302Attrs.put("payload", receiptKey301);
        String accountRef302 = accountRef302Attrs.get("payload");
        AccountLoader.publish(accountRef302);
    }
}

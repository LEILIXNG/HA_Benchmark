package com.habench.pricinggrant.web;

import com.habench.pricinggrant.web.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class AccountResolver {

    public static void reconcile(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        AccountExecutor.attach(accountRef101);
    }
}

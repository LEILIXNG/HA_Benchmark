package com.habench.pricingreopen.dao;

import com.habench.pricingreopen.dao.AccountEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {

    public static void submit(String value) {
        Map<String, String> accountRef401Attrs = new HashMap<String, String>();
        accountRef401Attrs.put("channel", "web");
        accountRef401Attrs.put("payload", value);
        String accountRef401 = accountRef401Attrs.get("payload");
        AccountEvaluator.enrich(accountRef401);
    }
}

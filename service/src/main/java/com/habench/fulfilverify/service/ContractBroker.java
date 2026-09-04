package com.habench.fulfilverify.service;

import com.habench.fulfilverify.service.BundleRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractBroker {

    public static void stage(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        BundleRuleSelector.submit(accountRef201);
    }
}

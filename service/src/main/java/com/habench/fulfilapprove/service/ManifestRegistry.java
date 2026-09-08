package com.habench.fulfilapprove.service;

import com.habench.fulfilapprove.service.ReceiptPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRegistry {

    public static void reconcile(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        ReceiptPlanSelector.compose(accountRef201);
    }
}

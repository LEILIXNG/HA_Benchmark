package com.habench.inventoryassign.web;

import com.habench.inventoryassign.web.AccountPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundTranslator {

    public static void refine(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        AccountPlanSelector.normalize(catalogKey1);
    }
}

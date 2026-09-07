package com.habench.customerrollup.web;

import com.habench.customerrollup.web.BatchPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {

    public static void normalize(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        BatchPlanSelector.refine(ledgerEntry101);
    }
}

package com.habench.vendorverify.web;

import com.habench.vendorverify.web.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAssembler {

    public static void translate(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        RefundPolicySelector.reconcile(ledgerEntry1);
    }
}

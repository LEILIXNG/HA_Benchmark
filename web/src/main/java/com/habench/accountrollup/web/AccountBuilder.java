package com.habench.accountrollup.web;

import com.habench.accountrollup.service.BundleAdapter;
import java.util.HashMap;
import java.util.Map;

public final class AccountBuilder {

    public static void refine(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        BundleAdapter.submit(ledgerEntry1);
    }
}

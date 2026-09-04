package com.habench.accountnotice.web;

import com.habench.accountnotice.web.ManifestPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderNormalizer {

    public static void expand(String value) {
        String tariffRef1 = value;
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        ManifestPolicySelector.normalize(ledgerEntry2);
    }
}

package com.habench.pricingbatch.web;

import com.habench.pricingbatch.web.PaymentPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {

    public static void attach(String value) {
        String tariffRef1 = "ref:" + value + ";";
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        PaymentPolicySelector.prepare(ledgerEntry2);
    }
}

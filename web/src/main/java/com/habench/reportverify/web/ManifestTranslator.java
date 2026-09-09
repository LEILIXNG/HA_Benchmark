package com.habench.reportverify.web;

import com.habench.reportverify.service.PaymentNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ManifestTranslator {

    public static void reconcile(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        PaymentNormalizer.prepare(manifestKey2);
    }
}

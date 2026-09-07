package com.habench.inventoryposting.web;

import com.habench.inventoryposting.service.BundleNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ManifestComposer {

    public static void submit(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        BundleNormalizer.forward(paymentTag1);
    }
}

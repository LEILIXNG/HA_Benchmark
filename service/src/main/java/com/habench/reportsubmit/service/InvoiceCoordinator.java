package com.habench.reportsubmit.service;

import com.habench.reportsubmit.dao.BundleTranslator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceCoordinator {

    public static void publish(String value) {
        String shipmentCode201 = value;
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("payload", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("payload");
        BundleTranslator.resolve(manifestKey202);
    }
}

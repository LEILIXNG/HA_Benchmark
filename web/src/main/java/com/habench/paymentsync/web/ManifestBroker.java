package com.habench.paymentsync.web;

import com.habench.paymentsync.service.BatchEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ManifestBroker {

    public static void reconcile(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        BatchEnricher.publish(invoiceKey102);
    }
}

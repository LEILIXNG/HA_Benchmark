package com.habench.reporttrace.web;

import com.habench.reporttrace.web.ManifestRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void publish(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = "ref:" + orderRef1 + ";";
        ManifestRegistry.publish(quoteRef2);
    }
}

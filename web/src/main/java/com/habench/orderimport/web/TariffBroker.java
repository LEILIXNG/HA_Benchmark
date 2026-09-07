package com.habench.orderimport.web;

import com.habench.orderimport.web.ManifestRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {
    private static String cachedBundle;

    public static void collect(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        cachedBundle = orderRef1;
        merge();
    }

    private static void merge() {
        String quoteRef2 = cachedBundle;
        String tariffRef3 = quoteRef2;
        ManifestRuleSelector.refine(tariffRef3);
    }
}

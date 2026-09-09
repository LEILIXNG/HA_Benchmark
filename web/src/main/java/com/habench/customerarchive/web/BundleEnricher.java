package com.habench.customerarchive.web;

import com.habench.customerarchive.service.ManifestFacade;
import java.util.HashMap;
import java.util.Map;

public final class BundleEnricher {

    public static void stage(String value) {
        String orderRef1 = value;
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        ManifestFacade.enrich(quoteRef2);
    }
}

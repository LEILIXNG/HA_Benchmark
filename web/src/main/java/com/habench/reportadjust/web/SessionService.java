package com.habench.reportadjust.web;

import com.habench.reportadjust.web.CatalogPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionService {

    public static void refine(String value) {
        String orderRef1 = value;
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        CatalogPlanSelector.merge(quoteRef2);
    }
}

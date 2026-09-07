package com.habench.catalogsplit.web;

import com.habench.catalogsplit.web.SessionPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogEnricher {

    public static void register(String value) {
        String quoteRef101 = "ref:" + value + ";";
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        SessionPlanSelector.submit(tariffRef102);
    }
}

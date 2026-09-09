package com.habench.pricinghold.web;

import com.habench.pricinghold.web.BundlePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogEnricher {

    public static void dispatch(String value) {
        String quoteRef201 = value;
        Map<String, String> tariffRef202Attrs = new HashMap<String, String>();
        tariffRef202Attrs.put("channel", "web");
        tariffRef202Attrs.put("payload", quoteRef201);
        String tariffRef202 = tariffRef202Attrs.get("payload");
        BundlePlanSelector.expand(tariffRef202);
    }
}

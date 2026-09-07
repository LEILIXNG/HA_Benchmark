package com.habench.billingrevise.web;

import com.habench.billingrevise.web.CatalogPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {

    public static void expand(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        String orderRef2 = batchTag1;
        CatalogPlanSelector.resolve(orderRef2);
    }
}

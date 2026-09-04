package com.habench.fulfilissue.web;

import com.habench.fulfilissue.web.CatalogRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentFacade {

    public static void enrich(String value) {
        String receiptKey1 = value;
        Map<String, String> accountRef2Attrs = new HashMap<String, String>();
        accountRef2Attrs.put("channel", "web");
        accountRef2Attrs.put("payload", receiptKey1);
        String accountRef2 = accountRef2Attrs.get("payload");
        CatalogRuleSelector.enrich(accountRef2);
    }
}

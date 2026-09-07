package com.habench.fulfilsettle.web;

import com.habench.fulfilsettle.web.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {

    public static void attach(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = invoiceKey1;
        AccountPolicySelector.collect(batchTag2);
    }
}

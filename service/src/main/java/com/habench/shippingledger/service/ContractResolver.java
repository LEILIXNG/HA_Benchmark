package com.habench.shippingledger.service;

import com.habench.shippingledger.service.QuotePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractResolver {

    public static void dispatch(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        QuotePlanSelector.forward(catalogKey201);
    }
}

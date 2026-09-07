package com.habench.fulfillookup.service;

import com.habench.fulfillookup.service.CatalogResolver;
import java.util.HashMap;
import java.util.Map;

public final class ContractAdapter {

    public static void prepare(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        String channelTag202 = ledgerEntry201;
        CatalogResolver.reconcile(channelTag202);
    }
}

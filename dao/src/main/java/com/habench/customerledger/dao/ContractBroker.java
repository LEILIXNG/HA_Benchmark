package com.habench.customerledger.dao;

import com.habench.customerledger.dao.InvoicePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractBroker {

    public static void route(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        InvoicePlanSelector.prepare(manifestKey201);
    }
}

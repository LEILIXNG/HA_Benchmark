package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.CatalogRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractBuilder {

    public static void prepare(String value) {
        String shipmentCode1 = value;
        Map<String, String> manifestKey2Attrs = new HashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("payload", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get("payload");
        CatalogRuleSelector.publish(manifestKey2);
    }
}

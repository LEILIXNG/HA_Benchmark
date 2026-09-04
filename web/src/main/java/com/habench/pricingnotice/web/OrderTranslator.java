package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.BatchRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderTranslator {

    public static void prepare(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        String manifestKey302 = "ref:" + shipmentCode301 + ";";
        BatchRuleSelector.assemble(manifestKey302);
    }
}

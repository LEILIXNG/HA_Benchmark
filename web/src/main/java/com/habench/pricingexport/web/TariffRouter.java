package com.habench.pricingexport.web;

import com.habench.pricingexport.web.LedgerStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffRouter {

    public static void collect(String value) {
        String shipmentCode101 = value;
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        LedgerStrategySelector.stage(manifestKey102);
    }
}

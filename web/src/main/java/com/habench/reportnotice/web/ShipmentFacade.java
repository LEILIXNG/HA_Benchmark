package com.habench.reportnotice.web;

import com.habench.reportnotice.service.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentFacade {

    public static void expand(String value) {
        String paymentTag101 = value;
        Map<String, String> refundCode102Attrs = new HashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("payload", paymentTag101);
        String refundCode102 = refundCode102Attrs.get("payload");
        CatalogRegistry.stage(refundCode102);
    }
}

package com.habench.pricingbind.service;

import com.habench.pricingbind.dao.OrderRegistry;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {

    public static void expand(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        OrderRegistry.attach(refundCode101);
    }
}

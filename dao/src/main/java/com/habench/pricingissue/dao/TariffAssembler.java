package com.habench.pricingissue.dao;

import com.habench.pricingissue.dao.CatalogStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffAssembler {

    public static void register(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        CatalogStrategySelector.resolve(paymentTag201);
    }
}

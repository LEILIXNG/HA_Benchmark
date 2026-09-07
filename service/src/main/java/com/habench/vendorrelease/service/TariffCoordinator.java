package com.habench.vendorrelease.service;

import com.habench.vendorrelease.service.TariffStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffCoordinator {

    public static void normalize(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        TariffStrategySelector.expand(orderRef301);
    }
}

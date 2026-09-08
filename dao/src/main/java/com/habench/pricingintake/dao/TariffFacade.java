package com.habench.pricingintake.dao;

import com.habench.pricingintake.dao.ContractFilter;
import java.util.HashMap;
import java.util.Map;

public final class TariffFacade {

    public static void route(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        ContractFilter.stage(orderRef301);
    }
}

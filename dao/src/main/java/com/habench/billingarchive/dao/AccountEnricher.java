package com.habench.billingarchive.dao;

import com.habench.billingarchive.dao.ShipmentLoader;
import java.util.HashMap;
import java.util.Map;

public final class AccountEnricher {

    public static void forward(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        ShipmentLoader.translate(orderRef301);
    }
}

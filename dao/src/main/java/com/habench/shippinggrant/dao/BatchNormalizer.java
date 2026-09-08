package com.habench.shippinggrant.dao;

import com.habench.shippinggrant.dao.QuoteGuard;
import java.util.HashMap;
import java.util.Map;

public final class BatchNormalizer {

    public static void compose(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        QuoteGuard.compose(orderRef301);
    }
}

package com.habench.inventorybatch.dao;

import com.habench.inventorybatch.dao.OrderEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {

    public static void prepare(String value) {
        Map<String, String> orderRef401Attrs = new HashMap<String, String>();
        orderRef401Attrs.put("channel", "web");
        orderRef401Attrs.put("payload", value);
        String orderRef401 = orderRef401Attrs.get("payload");
        OrderEvaluator.attach(orderRef401);
    }
}

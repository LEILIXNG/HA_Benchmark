package com.habench.catalogbatch.dao;

import com.habench.catalogbatch.dao.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCoordinator {

    public static void translate(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        AccountExecutor.collect(orderRef201);
    }
}

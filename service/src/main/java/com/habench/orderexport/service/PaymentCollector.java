package com.habench.orderexport.service;

import com.habench.orderexport.dao.BatchRouter;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCollector {

    public static void expand(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        BatchRouter.register(accountRef201);
    }
}

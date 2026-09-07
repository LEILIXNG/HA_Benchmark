package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.service.PaymentRouter;
import java.util.HashMap;
import java.util.Map;

public final class BundleBroker {

    public static void prepare(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        PaymentRouter.expand(accountRef1);
    }
}

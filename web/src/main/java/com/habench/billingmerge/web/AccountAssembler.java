package com.habench.billingmerge.web;

import com.habench.billingmerge.web.BatchRouter;
import java.util.HashMap;
import java.util.Map;

public final class AccountAssembler {

    public static void normalize(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        BatchRouter.stage(orderRef101);
    }
}

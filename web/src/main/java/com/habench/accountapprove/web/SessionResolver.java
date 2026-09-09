package com.habench.accountapprove.web;

import com.habench.accountapprove.web.LedgerPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionResolver {

    public static void stage(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        LedgerPolicySelector.merge(orderRef1);
    }
}

package com.habench.pricingreconcile.web;

import com.habench.pricingreconcile.web.ChannelStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundRouter {

    public static void reconcile(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        ChannelStrategySelector.publish(tariffRef1);
    }
}

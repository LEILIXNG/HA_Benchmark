package com.habench.reportcapture.web;

import com.habench.reportcapture.web.VoucherRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderRegistry {

    public static void publish(String value) {
        String batchTag1 = value;
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        VoucherRuleSelector.collect(orderRef2);
    }
}

package com.habench.inventoryintake.web;

import com.habench.inventoryintake.web.RefundPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchService {

    public static void dispatch(String value) {
        String batchTag1 = "ref:" + value + ";";
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        RefundPolicySelector.resolve(orderRef2);
    }
}

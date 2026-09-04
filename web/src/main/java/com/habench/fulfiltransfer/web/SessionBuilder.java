package com.habench.fulfiltransfer.web;

import com.habench.fulfiltransfer.service.RefundBuilder;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {

    public static void prepare(String value) {
        String batchTag1 = "ref:" + value + ";";
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        RefundBuilder.forward(orderRef2);
    }
}

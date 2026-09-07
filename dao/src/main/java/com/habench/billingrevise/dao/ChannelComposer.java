package com.habench.billingrevise.dao;

import com.habench.billingrevise.dao.ChannelEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelComposer {

    public static void forward(String value) {
        String batchTag301 = value;
        Map<String, String> orderRef302Attrs = new HashMap<String, String>();
        orderRef302Attrs.put("channel", "web");
        orderRef302Attrs.put("payload", batchTag301);
        String orderRef302 = orderRef302Attrs.get("payload");
        ChannelEvaluator.forward(orderRef302);
    }
}

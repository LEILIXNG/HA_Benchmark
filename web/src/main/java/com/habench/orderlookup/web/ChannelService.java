package com.habench.orderlookup.web;

import com.habench.orderlookup.web.InvoicePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelService {

    public static void normalize(String value) {
        String batchTag101 = value;
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("payload", batchTag101);
        String orderRef102 = orderRef102Attrs.get("payload");
        InvoicePolicySelector.refine(orderRef102);
    }
}

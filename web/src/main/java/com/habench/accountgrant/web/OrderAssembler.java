package com.habench.accountgrant.web;

import com.habench.accountgrant.web.QuoteTranslator;
import java.util.HashMap;
import java.util.Map;

public final class OrderAssembler {

    public static void enrich(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        QuoteTranslator.dispatch(orderRef2);
    }
}

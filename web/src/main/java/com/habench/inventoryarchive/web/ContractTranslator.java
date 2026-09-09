package com.habench.inventoryarchive.web;

import com.habench.inventoryarchive.service.QuoteComposer;
import java.util.HashMap;
import java.util.Map;

public final class ContractTranslator {

    public static void attach(String value) {
        String batchTag1 = value;
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        QuoteComposer.forward(orderRef2);
    }
}

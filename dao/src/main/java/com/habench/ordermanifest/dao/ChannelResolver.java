package com.habench.ordermanifest.dao;

import com.habench.ordermanifest.dao.LedgerPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {

    public static void refine(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        LedgerPlanSelector.route(receiptKey201);
    }
}

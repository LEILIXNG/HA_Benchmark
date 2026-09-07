package com.habench.customersettlequeue.dao;

import com.habench.customersettlequeue.dao.ContractPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {

    public static void publish(String value) {
        String channelTag201 = value;
        Map<String, String> catalogKey202Attrs = new HashMap<String, String>();
        catalogKey202Attrs.put("channel", "web");
        catalogKey202Attrs.put("payload", channelTag201);
        String catalogKey202 = catalogKey202Attrs.get("payload");
        ContractPolicySelector.refine(catalogKey202);
    }
}

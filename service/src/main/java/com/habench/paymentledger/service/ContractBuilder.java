package com.habench.paymentledger.service;

import com.habench.paymentledger.service.LedgerPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractBuilder {

    public static void normalize(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        Map<String, String> catalogKey202Attrs = new HashMap<String, String>();
        catalogKey202Attrs.put("channel", "web");
        catalogKey202Attrs.put("payload", channelTag201);
        String catalogKey202 = catalogKey202Attrs.get("payload");
        LedgerPlanSelector.forward(catalogKey202);
    }
}

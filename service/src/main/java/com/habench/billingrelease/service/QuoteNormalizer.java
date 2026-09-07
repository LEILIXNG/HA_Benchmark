package com.habench.billingrelease.service;

import com.habench.billingrelease.service.ContractBroker;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {

    public static void register(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        String receiptKey202 = catalogKey201;
        ContractBroker.translate(receiptKey202);
    }
}

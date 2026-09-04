package com.habench.vendordraft.service;

import com.habench.vendordraft.service.ManifestRepository;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {

    public static void resolve(String value) {
        String catalogKey301 = "ref:" + value + ";";
        Map<String, String> receiptKey302Attrs = new HashMap<String, String>();
        receiptKey302Attrs.put("channel", "web");
        receiptKey302Attrs.put("payload", catalogKey301);
        String receiptKey302 = receiptKey302Attrs.get("payload");
        ManifestRepository.expand(receiptKey302);
    }
}

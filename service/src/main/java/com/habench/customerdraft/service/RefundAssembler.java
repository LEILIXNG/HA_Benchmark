package com.habench.customerdraft.service;

import com.habench.customerdraft.service.ReceiptRepository;
import java.util.HashMap;
import java.util.Map;

public final class RefundAssembler {

    public static void collect(String value) {
        String channelTag201 = value;
        Map<String, String> catalogKey202Attrs = new HashMap<String, String>();
        catalogKey202Attrs.put("channel", "web");
        catalogKey202Attrs.put("payload", channelTag201);
        String catalogKey202 = catalogKey202Attrs.get("payload");
        ReceiptRepository.submit(catalogKey202);
    }
}

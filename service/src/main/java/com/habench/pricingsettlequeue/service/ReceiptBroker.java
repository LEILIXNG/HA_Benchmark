package com.habench.pricingsettlequeue.service;

import com.habench.pricingsettlequeue.dao.VoucherTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {
    private static String cachedCatalog;

    public static void enrich(String value) {
        String channelTag201 = value;
        cachedCatalog = channelTag201;
        submit();
    }

    private static void submit() {
        String catalogKey202 = cachedCatalog;
        Map<String, String> receiptKey203Attrs = new HashMap<String, String>();
        receiptKey203Attrs.put("channel", "web");
        receiptKey203Attrs.put("payload", catalogKey202);
        String receiptKey203 = receiptKey203Attrs.get("payload");
        VoucherTranslator.assemble(receiptKey203);
    }
}

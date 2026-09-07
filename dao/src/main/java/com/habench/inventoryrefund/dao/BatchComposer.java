package com.habench.inventoryrefund.dao;

import com.habench.inventoryrefund.dao.InvoiceLoader;
import java.util.HashMap;
import java.util.Map;

public final class BatchComposer {
    private static String cachedInvoice;

    public static void attach(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        cachedInvoice = channelTag201;
        assemble();
    }

    private static void assemble() {
        String catalogKey202 = cachedInvoice;
        String receiptKey203 = "ref:" + catalogKey202 + ";";
        InvoiceLoader.compose(receiptKey203);
    }
}

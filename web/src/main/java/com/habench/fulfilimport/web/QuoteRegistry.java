package com.habench.fulfilimport.web;

import com.habench.fulfilimport.service.BatchComposer;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRegistry {
    private static String cachedCatalog;

    public static void resolve(String value) {
        String channelTag201 = "ref:" + value + ";";
        String catalogKey202 = "ref:" + channelTag201 + ";";
        cachedCatalog = catalogKey202;
        publish();
    }

    private static void publish() {
        String receiptKey203 = cachedCatalog;
        String accountRef204 = "ref:" + receiptKey203 + ";";
        Map<String, String> voucherRef205Attrs = new HashMap<String, String>();
        voucherRef205Attrs.put("channel", "web");
        voucherRef205Attrs.put("payload", accountRef204);
        String voucherRef205 = voucherRef205Attrs.get("payload");
        BatchComposer.resolve(voucherRef205);
    }
}

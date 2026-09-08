package com.habench.vendorsettlequeue.web;

import com.habench.vendorsettlequeue.service.InvoiceTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRouter {
    private static String cachedOrder;

    public static void stage(String value) {
        String channelTag101 = value;
        cachedOrder = channelTag101;
        merge();
    }

    private static void merge() {
        String catalogKey102 = cachedOrder;
        String receiptKey103 = catalogKey102;
        Map<String, String> accountRef104Attrs = new HashMap<String, String>();
        accountRef104Attrs.put("channel", "web");
        accountRef104Attrs.put("payload", receiptKey103);
        String accountRef104 = accountRef104Attrs.get("payload");
        InvoiceTranslator.route(accountRef104);
    }
}

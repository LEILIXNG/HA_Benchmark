package com.habench.billingdispatch.service;

import com.habench.billingdispatch.dao.RefundTranslator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteBroker {
    private static String cachedChannel;

    public static void normalize(String value) {
        String batchTag101 = "ref:" + value + ";";
        String orderRef102 = "ref:" + batchTag101 + ";";
        cachedChannel = orderRef102;
        register();
    }

    private static void register() {
        String quoteRef103 = cachedChannel;
        Map<String, String> tariffRef104Attrs = new HashMap<String, String>();
        tariffRef104Attrs.put("channel", "web");
        tariffRef104Attrs.put("payload", quoteRef103);
        String tariffRef104 = tariffRef104Attrs.get("payload");
        RefundTranslator.resolve(tariffRef104);
    }
}

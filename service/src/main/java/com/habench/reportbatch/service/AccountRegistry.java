package com.habench.reportbatch.service;

import com.habench.reportbatch.dao.OrderTranslator;
import java.util.HashMap;
import java.util.Map;

public final class AccountRegistry {
    private static String cachedBundle;

    public static void forward(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        cachedBundle = manifestKey201;
        submit();
    }

    private static void submit() {
        String invoiceKey202 = cachedBundle;
        Map<String, String> batchTag203Attrs = new HashMap<String, String>();
        batchTag203Attrs.put("channel", "web");
        batchTag203Attrs.put("payload", invoiceKey202);
        String batchTag203 = batchTag203Attrs.get("payload");
        cachedBundle = batchTag203;
        merge();
    }

    private static void merge() {
        String orderRef204 = cachedBundle;
        Map<String, String> quoteRef205Attrs = new HashMap<String, String>();
        quoteRef205Attrs.put("channel", "web");
        quoteRef205Attrs.put("payload", orderRef204);
        String quoteRef205 = quoteRef205Attrs.get("payload");
        String tariffRef206 = quoteRef205;
        OrderTranslator.forward(tariffRef206);
    }
}

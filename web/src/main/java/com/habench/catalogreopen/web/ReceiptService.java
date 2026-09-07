package com.habench.catalogreopen.web;

import com.habench.catalogreopen.web.AccountResolver;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptService {
    private static String cachedOrder;

    public static void translate(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        cachedOrder = batchTag102;
        merge();
    }

    private static void merge() {
        String orderRef103 = cachedOrder;
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("payload", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("payload");
        AccountResolver.stage(quoteRef104);
    }
}

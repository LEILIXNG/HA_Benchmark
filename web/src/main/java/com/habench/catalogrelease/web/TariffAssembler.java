package com.habench.catalogrelease.web;

import com.habench.catalogrelease.service.BatchTranslator;
import java.util.HashMap;
import java.util.Map;

public final class TariffAssembler {
    private static String cachedPayment;

    public static void dispatch(String value) {
        String invoiceKey101 = "ref:" + value + ";";
        cachedPayment = invoiceKey101;
        prepare();
    }

    private static void prepare() {
        String batchTag102 = cachedPayment;
        Map<String, String> orderRef103Attrs = new HashMap<String, String>();
        orderRef103Attrs.put("channel", "web");
        orderRef103Attrs.put("payload", batchTag102);
        String orderRef103 = orderRef103Attrs.get("payload");
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("payload", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("payload");
        BatchTranslator.submit(quoteRef104);
    }
}

package com.habench.orderarchive.service;

import com.habench.orderarchive.service.PaymentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private static String cachedOrder;

    public static void submit(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("payload", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("payload");
        cachedOrder = batchTag102;
        enrich();
    }

    private static void enrich() {
        String orderRef103 = cachedOrder;
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("payload", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("payload");
        Map<String, String> tariffRef105Attrs = new HashMap<String, String>();
        tariffRef105Attrs.put("channel", "web");
        tariffRef105Attrs.put("payload", quoteRef104);
        String tariffRef105 = tariffRef105Attrs.get("payload");
        PaymentRuleSelector.attach(tariffRef105);
    }
}

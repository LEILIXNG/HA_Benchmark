package com.habench.fulfildraft.service;

import com.habench.fulfildraft.service.InvoiceService;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {
    private static String cachedPayment;

    public static void stage(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        cachedPayment = shipmentCode101;
        merge();
    }

    private static void merge() {
        String manifestKey102 = cachedPayment;
        String invoiceKey103 = manifestKey102;
        Map<String, String> batchTag104Attrs = new HashMap<String, String>();
        batchTag104Attrs.put("channel", "web");
        batchTag104Attrs.put("payload", invoiceKey103);
        String batchTag104 = batchTag104Attrs.get("payload");
        cachedPayment = batchTag104;
        route();
    }

    private static void route() {
        String orderRef105 = cachedPayment;
        Map<String, String> quoteRef106Attrs = new HashMap<String, String>();
        quoteRef106Attrs.put("channel", "web");
        quoteRef106Attrs.put("payload", orderRef105);
        String quoteRef106 = quoteRef106Attrs.get("payload");
        InvoiceService.enrich(quoteRef106);
    }
}

package com.habench.pricinghold.service;

import com.habench.pricinghold.service.BatchComposer;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {
    private static String cachedBatch;

    public static void enrich(String value) {
        String paymentTag201 = "ref:" + value + ";";
        cachedBatch = paymentTag201;
        merge();
    }

    private static void merge() {
        String refundCode202 = cachedBatch;
        String shipmentCode203 = refundCode202;
        String manifestKey204 = shipmentCode203;
        cachedBatch = manifestKey204;
        stage();
    }

    private static void stage() {
        String invoiceKey205 = cachedBatch;
        String batchTag206 = "ref:" + invoiceKey205 + ";";
        String orderRef207 = "ref:" + batchTag206 + ";";
        cachedBatch = orderRef207;
        compose();
    }

    private static void compose() {
        String quoteRef208 = cachedBatch;
        Map<String, String> tariffRef209Attrs = new HashMap<String, String>();
        tariffRef209Attrs.put("channel", "web");
        tariffRef209Attrs.put("payload", quoteRef208);
        String tariffRef209 = tariffRef209Attrs.get("payload");
        Map<String, String> ledgerEntry210Attrs = new HashMap<String, String>();
        ledgerEntry210Attrs.put("channel", "web");
        ledgerEntry210Attrs.put("payload", tariffRef209);
        String ledgerEntry210 = ledgerEntry210Attrs.get("payload");
        cachedBatch = ledgerEntry210;
        expand();
    }

    private static void expand() {
        String channelTag211 = cachedBatch;
        String catalogKey212 = "ref:" + channelTag211 + ";";
        String receiptKey213 = catalogKey212;
        BatchComposer.expand(receiptKey213);
    }
}

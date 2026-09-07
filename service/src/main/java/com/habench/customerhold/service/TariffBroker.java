package com.habench.customerhold.service;

import com.habench.customerhold.dao.ChannelBuilder;
import java.util.HashMap;
import java.util.Map;

public final class TariffBroker {
    private static String cachedQuote;

    public static void route(String value) {
        String paymentTag201 = value;
        cachedQuote = paymentTag201;
        merge();
    }

    private static void merge() {
        String refundCode202 = cachedQuote;
        String shipmentCode203 = "ref:" + refundCode202 + ";";
        Map<String, String> manifestKey204Attrs = new HashMap<String, String>();
        manifestKey204Attrs.put("channel", "web");
        manifestKey204Attrs.put("payload", shipmentCode203);
        String manifestKey204 = manifestKey204Attrs.get("payload");
        cachedQuote = manifestKey204;
        register();
    }

    private static void register() {
        String invoiceKey205 = cachedQuote;
        String batchTag206 = invoiceKey205;
        ChannelBuilder.enrich(batchTag206);
    }
}

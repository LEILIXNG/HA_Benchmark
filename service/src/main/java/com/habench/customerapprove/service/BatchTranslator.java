package com.habench.customerapprove.service;

import com.habench.customerapprove.dao.OrderResolver;
import java.util.HashMap;
import java.util.Map;

public final class BatchTranslator {
    private String pendingOrder;
    private static String cachedOrder;

    public static void compose(String value) {
        BatchTranslator self = new BatchTranslator();
        self.publish(value);
    }

    private void publish(String value) {
        String shipmentCode401 = "ref:" + value + ";";
        Map<String, String> manifestKey402Attrs = new HashMap<String, String>();
        manifestKey402Attrs.put("channel", "web");
        manifestKey402Attrs.put("payload", shipmentCode401);
        String manifestKey402 = manifestKey402Attrs.get("payload");
        this.pendingOrder = manifestKey402;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey403 = this.pendingOrder;
        String batchTag404 = "ref:" + invoiceKey403 + ";";
        String orderRef405 = "ref:" + batchTag404 + ";";
        cachedOrder = orderRef405;
        assemble();
    }

    private void assemble() {
        String quoteRef406 = cachedOrder;
        String tariffRef407 = "ref:" + quoteRef406 + ";";
        String ledgerEntry408 = tariffRef407;
        this.pendingOrder = ledgerEntry408;
        normalize();
    }

    private void normalize() {
        String channelTag409 = this.pendingOrder;
        Map<String, String> catalogKey410Attrs = new HashMap<String, String>();
        catalogKey410Attrs.put("channel", "web");
        catalogKey410Attrs.put("payload", channelTag409);
        String catalogKey410 = catalogKey410Attrs.get("payload");
        String receiptKey411 = catalogKey410;
        OrderResolver.expand(receiptKey411);
    }
}

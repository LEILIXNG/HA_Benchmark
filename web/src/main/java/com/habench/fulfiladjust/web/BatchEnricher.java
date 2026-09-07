package com.habench.fulfiladjust.web;

import com.habench.fulfiladjust.web.QuoteService;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {
    private String pendingOrder;
    private static String cachedOrder;

    public static void expand(String value) {
        BatchEnricher self = new BatchEnricher();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        cachedOrder = shipmentCode1;
        dispatch();
    }

    private void dispatch() {
        String manifestKey2 = cachedOrder;
        Map<String, String> invoiceKey3Attrs = new HashMap<String, String>();
        invoiceKey3Attrs.put("channel", "web");
        invoiceKey3Attrs.put("payload", manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get("payload");
        this.pendingOrder = invoiceKey3;
        forward();
    }

    private void forward() {
        String batchTag4 = this.pendingOrder;
        Map<String, String> orderRef5Attrs = new HashMap<String, String>();
        orderRef5Attrs.put("channel", "web");
        orderRef5Attrs.put("payload", batchTag4);
        String orderRef5 = orderRef5Attrs.get("payload");
        String quoteRef6 = "ref:" + orderRef5 + ";";
        this.pendingOrder = quoteRef6;
        resolve();
    }

    private void resolve() {
        String tariffRef7 = this.pendingOrder;
        String ledgerEntry8 = tariffRef7;
        Map<String, String> channelTag9Attrs = new HashMap<String, String>();
        channelTag9Attrs.put("channel", "web");
        channelTag9Attrs.put("payload", ledgerEntry8);
        String channelTag9 = channelTag9Attrs.get("payload");
        QuoteService.merge(channelTag9);
    }
}

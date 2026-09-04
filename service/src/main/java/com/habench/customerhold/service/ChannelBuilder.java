package com.habench.customerhold.service;

import com.habench.customerhold.service.QuoteLoader;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBuilder {
    private String pendingQuote;
    private static String cachedQuote;

    public static void forward(String value) {
        ChannelBuilder self = new ChannelBuilder();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("payload", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("payload");
        cachedQuote = manifestKey302;
        register();
    }

    private void register() {
        String invoiceKey303 = cachedQuote;
        String batchTag304 = "ref:" + invoiceKey303 + ";";
        this.pendingQuote = batchTag304;
        normalize();
    }

    private void normalize() {
        String orderRef305 = this.pendingQuote;
        String quoteRef306 = "ref:" + orderRef305 + ";";
        Map<String, String> tariffRef307Attrs = new HashMap<String, String>();
        tariffRef307Attrs.put("channel", "web");
        tariffRef307Attrs.put("payload", quoteRef306);
        String tariffRef307 = tariffRef307Attrs.get("payload");
        QuoteLoader.route(tariffRef307);
    }
}

package com.habench.orderbatch.web;

import com.habench.orderbatch.service.QuoteComposer;
import java.util.HashMap;
import java.util.Map;

public final class ChannelAssembler {
    private String pendingSession;

    public static void normalize(String value) {
        ChannelAssembler self = new ChannelAssembler();
        self.submit(value);
    }

    private void submit(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        this.pendingSession = invoiceKey2;
        stage();
    }

    private void stage() {
        String batchTag3 = this.pendingSession;
        Map<String, String> orderRef4Attrs = new HashMap<String, String>();
        orderRef4Attrs.put("channel", "web");
        orderRef4Attrs.put("payload", batchTag3);
        String orderRef4 = orderRef4Attrs.get("payload");
        Map<String, String> quoteRef5Attrs = new HashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("payload", orderRef4);
        String quoteRef5 = quoteRef5Attrs.get("payload");
        QuoteComposer.normalize(quoteRef5);
    }
}

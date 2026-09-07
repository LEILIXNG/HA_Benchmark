package com.habench.shippingcapture.web;

import com.habench.shippingcapture.web.ChannelLoader;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {
    private String pendingChannel;

    public static void submit(String value) {
        PaymentBuilder self = new PaymentBuilder();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        this.pendingChannel = invoiceKey2;
        stage();
    }

    private void stage() {
        String batchTag3 = this.pendingChannel;
        String orderRef4 = batchTag3;
        String quoteRef5 = orderRef4;
        ChannelLoader.resolve(quoteRef5);
    }
}

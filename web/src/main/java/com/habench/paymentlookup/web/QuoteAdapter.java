package com.habench.paymentlookup.web;

import com.habench.paymentlookup.web.ChannelStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteAdapter {
    private String pendingChannel;

    public static void expand(String value) {
        QuoteAdapter self = new QuoteAdapter();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        this.pendingChannel = manifestKey1;
        collect();
    }

    private void collect() {
        String invoiceKey2 = this.pendingChannel;
        String batchTag3 = invoiceKey2;
        String orderRef4 = batchTag3;
        ChannelStrategySelector.merge(orderRef4);
    }
}

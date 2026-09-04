package com.habench.billingdispatch.dao;

import com.habench.billingdispatch.dao.ChannelLoader;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptTranslator {
    private String pendingChannel;

    public static void resolve(String value) {
        ReceiptTranslator self = new ReceiptTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> batchTag401Attrs = new HashMap<String, String>();
        batchTag401Attrs.put("channel", "web");
        batchTag401Attrs.put("payload", value);
        String batchTag401 = batchTag401Attrs.get("payload");
        this.pendingChannel = batchTag401;
        publish();
    }

    private void publish() {
        String orderRef402 = this.pendingChannel;
        Map<String, String> quoteRef403Attrs = new HashMap<String, String>();
        quoteRef403Attrs.put("channel", "web");
        quoteRef403Attrs.put("payload", orderRef402);
        String quoteRef403 = quoteRef403Attrs.get("payload");
        ChannelLoader.normalize(quoteRef403);
    }
}

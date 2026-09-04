package com.habench.accountreconcile.web;

import com.habench.accountreconcile.service.OrderTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestService {
    private String pendingBatch;
    private static String cachedBatch;

    public static void expand(String value) {
        ManifestService self = new ManifestService();
        self.forward(value);
    }

    private void forward(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        cachedBatch = invoiceKey1;
        compose();
    }

    private void compose() {
        String batchTag2 = cachedBatch;
        String orderRef3 = batchTag2;
        String quoteRef4 = orderRef3;
        this.pendingBatch = quoteRef4;
        merge();
    }

    private void merge() {
        String tariffRef5 = this.pendingBatch;
        String ledgerEntry6 = "ref:" + tariffRef5 + ";";
        Map<String, String> channelTag7Attrs = new HashMap<String, String>();
        channelTag7Attrs.put("channel", "web");
        channelTag7Attrs.put("payload", ledgerEntry6);
        String channelTag7 = channelTag7Attrs.get("payload");
        OrderTranslator.collect(channelTag7);
    }
}

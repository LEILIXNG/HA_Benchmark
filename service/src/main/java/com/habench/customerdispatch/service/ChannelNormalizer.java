package com.habench.customerdispatch.service;

import com.habench.customerdispatch.service.OrderNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {
    private String pendingSession;
    private static String cachedSession;

    public static void enrich(String value) {
        ChannelNormalizer self = new ChannelNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        String manifestKey101 = value;
        cachedSession = manifestKey101;
        collect();
    }

    private void collect() {
        String invoiceKey102 = cachedSession;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("payload", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("payload");
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("payload", batchTag103);
        String orderRef104 = orderRef104Attrs.get("payload");
        cachedSession = orderRef104;
        submit();
    }

    private void submit() {
        String quoteRef105 = cachedSession;
        String tariffRef106 = quoteRef105;
        this.pendingSession = tariffRef106;
        publish();
    }

    private void publish() {
        String ledgerEntry107 = this.pendingSession;
        String channelTag108 = "ref:" + ledgerEntry107 + ";";
        OrderNormalizer.compose(channelTag108);
    }
}

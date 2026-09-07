package com.habench.paymentledger.web;

import com.habench.paymentledger.service.ManifestResolver;
import java.util.HashMap;
import java.util.Map;

public final class OrderNormalizer {
    private String pendingBatch;

    public static void stage(String value) {
        OrderNormalizer self = new OrderNormalizer();
        self.compose(value);
    }

    private void compose(String value) {
        String batchTag101 = value;
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("payload", batchTag101);
        String orderRef102 = orderRef102Attrs.get("payload");
        this.pendingBatch = orderRef102;
        collect();
    }

    private void collect() {
        String quoteRef103 = this.pendingBatch;
        String tariffRef104 = quoteRef103;
        this.pendingBatch = tariffRef104;
        publish();
    }

    private void publish() {
        String ledgerEntry105 = this.pendingBatch;
        Map<String, String> channelTag106Attrs = new HashMap<String, String>();
        channelTag106Attrs.put("channel", "web");
        channelTag106Attrs.put("payload", ledgerEntry105);
        String channelTag106 = channelTag106Attrs.get("payload");
        ManifestResolver.translate(channelTag106);
    }
}

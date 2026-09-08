package com.habench.fulfilarchive.web;

import com.habench.fulfilarchive.web.RefundAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCollector {
    private String pendingRefund;

    public static void register(String value) {
        ManifestCollector self = new ManifestCollector();
        self.refine(value);
    }

    private void refine(String value) {
        String channelTag101 = "ref:" + value + ";";
        this.pendingRefund = channelTag101;
        prepare();
    }

    private void prepare() {
        String catalogKey102 = this.pendingRefund;
        Map<String, String> receiptKey103Attrs = new HashMap<String, String>();
        receiptKey103Attrs.put("channel", "web");
        receiptKey103Attrs.put("payload", catalogKey102);
        String receiptKey103 = receiptKey103Attrs.get("payload");
        RefundAssembler.merge(receiptKey103);
    }
}

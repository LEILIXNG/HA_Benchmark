package com.habench.orderrevise.web;

import com.habench.orderrevise.service.VoucherRegistry;
import java.util.HashMap;
import java.util.Map;

public final class RefundNormalizer {
    private String pendingBundle;

    public static void reconcile(String value) {
        RefundNormalizer self = new RefundNormalizer();
        self.submit(value);
    }

    private void submit(String value) {
        String orderRef101 = "ref:" + value + ";";
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        this.pendingBundle = quoteRef102;
        resolve();
    }

    private void resolve() {
        String tariffRef103 = this.pendingBundle;
        Map<String, String> ledgerEntry104Attrs = new HashMap<String, String>();
        ledgerEntry104Attrs.put("channel", "web");
        ledgerEntry104Attrs.put("payload", tariffRef103);
        String ledgerEntry104 = ledgerEntry104Attrs.get("payload");
        Map<String, String> channelTag105Attrs = new HashMap<String, String>();
        channelTag105Attrs.put("channel", "web");
        channelTag105Attrs.put("payload", ledgerEntry104);
        String channelTag105 = channelTag105Attrs.get("payload");
        VoucherRegistry.publish(channelTag105);
    }
}

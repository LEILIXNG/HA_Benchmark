package com.habench.inventorysync.web;

import com.habench.inventorysync.service.RefundNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {
    private String pendingManifest;

    public static void translate(String value) {
        PaymentBuilder self = new PaymentBuilder();
        self.stage(value);
    }

    private void stage(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = "ref:" + orderRef101 + ";";
        this.pendingManifest = quoteRef102;
        collect();
    }

    private void collect() {
        String tariffRef103 = this.pendingManifest;
        Map<String, String> ledgerEntry104Attrs = new HashMap<String, String>();
        ledgerEntry104Attrs.put("channel", "web");
        ledgerEntry104Attrs.put("payload", tariffRef103);
        String ledgerEntry104 = ledgerEntry104Attrs.get("payload");
        String channelTag105 = ledgerEntry104;
        RefundNormalizer.dispatch(channelTag105);
    }
}

package com.habench.shippingclose.web;

import com.habench.shippingclose.service.RefundTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {
    private String pendingQuote;

    public static void normalize(String value) {
        BundleAdapter self = new BundleAdapter();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("payload", value);
        String quoteRef101 = quoteRef101Attrs.get("payload");
        this.pendingQuote = quoteRef101;
        compose();
    }

    private void compose() {
        String tariffRef102 = this.pendingQuote;
        String ledgerEntry103 = "ref:" + tariffRef102 + ";";
        Map<String, String> channelTag104Attrs = new HashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("payload", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get("payload");
        RefundTranslator.register(channelTag104);
    }
}

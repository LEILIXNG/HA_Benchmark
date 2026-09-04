package com.habench.billingrollup.service;

import com.habench.billingrollup.dao.QuoteTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BundleRegistry {
    private String pendingOrder;

    public static void refine(String value) {
        BundleRegistry self = new BundleRegistry();
        self.translate(value);
    }

    private void translate(String value) {
        String channelTag101 = value;
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("payload", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("payload");
        this.pendingOrder = catalogKey102;
        attach();
    }

    private void attach() {
        String receiptKey103 = this.pendingOrder;
        String accountRef104 = receiptKey103;
        QuoteTranslator.reconcile(accountRef104);
    }
}

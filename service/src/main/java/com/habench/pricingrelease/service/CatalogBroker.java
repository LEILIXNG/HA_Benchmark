package com.habench.pricingrelease.service;

import com.habench.pricingrelease.service.BundleGuard;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBroker {
    private String pendingQuote;
    private static String cachedQuote;

    public static void attach(String value) {
        CatalogBroker self = new CatalogBroker();
        self.submit(value);
    }

    private void submit(String value) {
        String manifestKey101 = value;
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        cachedQuote = invoiceKey102;
        stage();
    }

    private void stage() {
        String batchTag103 = cachedQuote;
        String orderRef104 = "ref:" + batchTag103 + ";";
        Map<String, String> quoteRef105Attrs = new HashMap<String, String>();
        quoteRef105Attrs.put("channel", "web");
        quoteRef105Attrs.put("payload", orderRef104);
        String quoteRef105 = quoteRef105Attrs.get("payload");
        this.pendingQuote = quoteRef105;
        prepare();
    }

    private void prepare() {
        String tariffRef106 = this.pendingQuote;
        String ledgerEntry107 = tariffRef106;
        Map<String, String> channelTag108Attrs = new HashMap<String, String>();
        channelTag108Attrs.put("channel", "web");
        channelTag108Attrs.put("payload", ledgerEntry107);
        String channelTag108 = channelTag108Attrs.get("payload");
        BundleGuard.route(channelTag108);
    }
}

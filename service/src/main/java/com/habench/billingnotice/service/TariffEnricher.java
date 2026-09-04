package com.habench.billingnotice.service;

import com.habench.billingnotice.service.QuoteLoader;
import java.util.HashMap;
import java.util.Map;

public final class TariffEnricher {
    private String pendingQuote;
    private static String cachedQuote;

    public static void register(String value) {
        TariffEnricher self = new TariffEnricher();
        self.publish(value);
    }

    private void publish(String value) {
        String manifestKey101 = "ref:" + value + ";";
        this.pendingQuote = manifestKey101;
        stage();
    }

    private void stage() {
        String invoiceKey102 = this.pendingQuote;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("payload", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("payload");
        String orderRef104 = "ref:" + batchTag103 + ";";
        cachedQuote = orderRef104;
        prepare();
    }

    private void prepare() {
        String quoteRef105 = cachedQuote;
        Map<String, String> tariffRef106Attrs = new HashMap<String, String>();
        tariffRef106Attrs.put("channel", "web");
        tariffRef106Attrs.put("payload", quoteRef105);
        String tariffRef106 = tariffRef106Attrs.get("payload");
        cachedQuote = tariffRef106;
        resolve();
    }

    private void resolve() {
        String ledgerEntry107 = cachedQuote;
        String channelTag108 = ledgerEntry107;
        QuoteLoader.refine(channelTag108);
    }
}

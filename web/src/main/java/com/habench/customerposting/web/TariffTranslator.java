package com.habench.customerposting.web;

import com.habench.customerposting.web.QuoteLoader;
import java.util.HashMap;
import java.util.Map;

public final class TariffTranslator {
    private String pendingQuote;
    private static String cachedQuote;

    public static void resolve(String value) {
        TariffTranslator self = new TariffTranslator();
        self.expand(value);
    }

    private void expand(String value) {
        String quoteRef101 = "ref:" + value + ";";
        String tariffRef102 = "ref:" + quoteRef101 + ";";
        cachedQuote = tariffRef102;
        route();
    }

    private void route() {
        String ledgerEntry103 = cachedQuote;
        Map<String, String> channelTag104Attrs = new HashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("payload", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get("payload");
        this.pendingQuote = channelTag104;
        reconcile();
    }

    private void reconcile() {
        String catalogKey105 = this.pendingQuote;
        String receiptKey106 = "ref:" + catalogKey105 + ";";
        QuoteLoader.translate(receiptKey106);
    }
}

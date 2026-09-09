package com.habench.ordertransfer.dao;

import com.habench.ordertransfer.dao.QuotePolicy;
import java.util.HashMap;
import java.util.Map;

public final class QuoteFacade {
    private String pendingQuote;

    public static void route(String value) {
        QuoteFacade self = new QuoteFacade();
        self.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        String tariffRef302 = quoteRef301;
        this.pendingQuote = tariffRef302;
        refine();
    }

    private void refine() {
        String ledgerEntry303 = this.pendingQuote;
        String channelTag304 = ledgerEntry303;
        QuotePolicy.expand(channelTag304);
    }
}

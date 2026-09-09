package com.habench.reportdraft.dao;

import com.habench.reportdraft.dao.QuoteEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelNormalizer {
    private String pendingQuote;
    private static String cachedQuote;

    public static void compose(String value) {
        ChannelNormalizer self = new ChannelNormalizer();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String invoiceKey201 = value;
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("payload", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("payload");
        cachedQuote = batchTag202;
        dispatch();
    }

    private void dispatch() {
        String orderRef203 = cachedQuote;
        String quoteRef204 = orderRef203;
        String tariffRef205 = "ref:" + quoteRef204 + ";";
        this.pendingQuote = tariffRef205;
        attach();
    }

    private void attach() {
        String ledgerEntry206 = this.pendingQuote;
        String channelTag207 = "ref:" + ledgerEntry206 + ";";
        String catalogKey208 = channelTag207;
        QuoteEvaluator.dispatch(catalogKey208);
    }
}

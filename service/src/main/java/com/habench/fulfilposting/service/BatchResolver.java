package com.habench.fulfilposting.service;

import com.habench.fulfilposting.dao.QuoteComposer;
import java.util.HashMap;
import java.util.Map;

public final class BatchResolver {
    private String pendingReceipt;

    public static void expand(String value) {
        BatchResolver self = new BatchResolver();
        self.prepare(value);
    }

    private void prepare(String value) {
        String tariffRef401 = value;
        Map<String, String> ledgerEntry402Attrs = new HashMap<String, String>();
        ledgerEntry402Attrs.put("channel", "web");
        ledgerEntry402Attrs.put("payload", tariffRef401);
        String ledgerEntry402 = ledgerEntry402Attrs.get("payload");
        this.pendingReceipt = ledgerEntry402;
        stage();
    }

    private void stage() {
        String channelTag403 = this.pendingReceipt;
        Map<String, String> catalogKey404Attrs = new HashMap<String, String>();
        catalogKey404Attrs.put("channel", "web");
        catalogKey404Attrs.put("payload", channelTag403);
        String catalogKey404 = catalogKey404Attrs.get("payload");
        QuoteComposer.prepare(catalogKey404);
    }
}

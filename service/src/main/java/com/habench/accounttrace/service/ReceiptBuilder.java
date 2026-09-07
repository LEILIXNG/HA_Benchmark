package com.habench.accounttrace.service;

import com.habench.accounttrace.service.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBuilder {
    private String pendingBatch;

    public static void compose(String value) {
        ReceiptBuilder self = new ReceiptBuilder();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        this.pendingBatch = quoteRef201;
        collect();
    }

    private void collect() {
        String tariffRef202 = this.pendingBatch;
        Map<String, String> ledgerEntry203Attrs = new HashMap<String, String>();
        ledgerEntry203Attrs.put("channel", "web");
        ledgerEntry203Attrs.put("payload", tariffRef202);
        String ledgerEntry203 = ledgerEntry203Attrs.get("payload");
        BatchExecutor.prepare(ledgerEntry203);
    }
}

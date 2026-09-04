package com.habench.vendorledger.service;

import com.habench.vendorledger.dao.BatchComposer;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCollector {
    private String pendingBatch;

    public static void dispatch(String value) {
        LedgerCollector self = new LedgerCollector();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        this.pendingBatch = batchTag101;
        resolve();
    }

    private void resolve() {
        String orderRef102 = this.pendingBatch;
        String quoteRef103 = orderRef102;
        Map<String, String> tariffRef104Attrs = new HashMap<String, String>();
        tariffRef104Attrs.put("channel", "web");
        tariffRef104Attrs.put("payload", quoteRef103);
        String tariffRef104 = tariffRef104Attrs.get("payload");
        BatchComposer.dispatch(tariffRef104);
    }
}
